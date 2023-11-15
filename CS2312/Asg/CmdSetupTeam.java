public class CmdSetupTeam extends RecordedCommand {
    private Team t;
    private Employee head;
    private JoinRecord jr;

    @Override
    public void execute(String[] tokens) {
        /*
         * Usage: setupTeam <team name> <team head name>
         */
        try {
            if (tokens.length < 3)
                throw new ExInsufficientCommandArguments();
            
            Company company = Company.getInstance();
            if (company.checkTeamExists(tokens[1]))
                throw new ExTeamAlreadyExists();
            head = company.searchEmployee(tokens[2]);
            try {
                Team anotherTeam = company.searchTeamByEmployee(head);
                throw new ExEmployeeHasJoinedAnotherTeam(head.getName(), anotherTeam.getTeamName());
            } catch (ExTeamNotFound e) {
                // do nothing
            }
            t = new Team(tokens[1], head);
            company.addTeam(t);
            jr = new JoinRecord(head, t);
            company.addJoinRecord(jr);

            RecordedCommand.addToUndoList(this);
            RecordedCommand.clearRedoList();
            System.out.println("Done.");
            
        } catch (ExInsufficientCommandArguments e) {
            System.out.println(e.getMessage());
        } catch (ExTeamAlreadyExists e) {
            System.out.println(e.getMessage());
        } catch (ExEmployeeNotFound e) {
            System.out.println(e.getMessage());
        } catch (ExEmployeeHasJoinedAnotherTeam e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void undoThis() {
        Company company = Company.getInstance();
        company.removeTeam(t);
        company.removeJoinRecord(jr);
    }

    @Override
    public void redoThis() {
        Company company = Company.getInstance();
        company.addTeam(t);
        company.addJoinRecord(jr);
    }
}
