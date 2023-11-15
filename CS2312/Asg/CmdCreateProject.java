public class CmdCreateProject extends RecordedCommand {
    private Project p;

    @Override
    public void execute(String[] tokens) {
        /*
         * Usage: createProject <project code> <start day: day> <duration: int>
         */
        try {
            if (tokens.length < 4)
                throw new ExInsufficientCommandArguments();
            
            Company company = Company.getInstance();
            if (company.checkProjectExists(tokens[1]))
                throw new ExProjectAlreadyExists();
            Day startDay = new Day(tokens[2]);
            int duration = Integer.parseInt(tokens[3]);
            Day endDay = startDay.advance(duration);
            p = new Project(tokens[1], startDay, endDay);
            company.addProject(p);

            RecordedCommand.addToUndoList(this);
            RecordedCommand.clearRedoList();
            System.out.println("Done.");
            
        } catch (NumberFormatException e) {
            System.out.println("Wrong number format for project duration!");
        } catch (ExInsufficientCommandArguments e) {
            System.out.println(e.getMessage());
        } catch (ExProjectAlreadyExists e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void undoThis() {
        Company company = Company.getInstance();
        company.removeProject(p);
    }

    @Override
    public void redoThis() {
        Company company = Company.getInstance();
        company.addProject(p);
    }
}
