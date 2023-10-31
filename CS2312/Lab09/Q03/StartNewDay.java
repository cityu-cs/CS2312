public class StartNewDay extends RecordedCommand {
    Day previousDay;
    Day newDay;
    
    @Override
    public void execute(String[] tokens) {
        newDay = new Day(tokens[1]);
        previousDay = SystemDate.getInstance().clone();
        SystemDate.getInstance().set(newDay);
        RecordedCommand.addToUndo(this);
        RecordedCommand.clearRedoList();
        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        SystemDate.getInstance().set(previousDay);
        RecordedCommand.addToRedo(this);
    }

    @Override
    public void redoMe() {
        SystemDate.getInstance().set(newDay);
        RecordedCommand.addToUndo(this);
    }
}
