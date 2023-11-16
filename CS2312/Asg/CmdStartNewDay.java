public class CmdStartNewDay extends RecordedCommand {
    Day oldDay;
    Day newDay;

    @Override
    public void execute(String[] tokens) {
        /*
         * Usage: startNewDay <date: day>
         */
        try {
            if (tokens.length != 2) {
                throw new ExInsufficientCommandArguments();
            }
            
            oldDay = SystemDate.getInstance();
            newDay = new Day(tokens[1]);
            SystemDate.setDay(newDay);

            RecordedCommand.addToUndoList(this);
            RecordedCommand.clearRedoList();
            System.out.println("Done.");
            
        } catch (ExInsufficientCommandArguments e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void undoThis() {
        SystemDate.setDay(oldDay);
    }

    @Override
    public void redoThis() {
        SystemDate.setDay(newDay);
    }
}
