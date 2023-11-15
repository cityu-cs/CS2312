public class CmdAssign extends RecordedCommand {
    private Assignment a;

    @Override
    public void execute(String[] tokens) {
        /*
         * Usage: assign <project code> <team name>
         */
        try {
            if (tokens.length < 3)
                throw new ExInsufficientCommandArguments();
            
            Company company = Company.getInstance();
            Project project = company.searchProject(tokens[1]);
            Team team = company.searchTeam(tokens[2]);
            a = new Assignment(project, team);
            company.addAssignment(a);

            RecordedCommand.addToUndoList(this);
            RecordedCommand.clearRedoList();
            System.out.println("Done.");
            
        } catch (ExInsufficientCommandArguments e) {
            System.out.println(e.getMessage());
        } catch (ExProjectNotFound e) {
            System.out.println(e.getMessage());
        } catch (ExTeamNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void undoThis() {
        Company company = Company.getInstance();
        company.removeAssignment(a);
    }

    @Override
    public void redoThis() {
        Company company = Company.getInstance();
        company.addAssignment(a);
    }
}
