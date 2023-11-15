public class CmdSetupTeam extends RecordedCommand {
    private Team t;

    @Override
    public void executeThis(String[] tokens) {
        /*
         * Usage: setupTeam <team name> <team head name>
         */
        try {
            if (tokens.length < 3)
                throw new ExInsufficientCommandArguments();
            Company company = Company.getInstance();
            t = new Team(
                tokens[1],
                company.searchEmployee(tokens[2])
            );
            company.addTeam(t);
        } catch (ExEmployeeNotFound e) {
            System.out.println(e.getMessage());
        } catch (ExInsufficientCommandArguments e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void undoThis() {
        Company company = Company.getInstance();
        company.removeTeam(t);
    }

    @Override
    public void redoThis() {
        Company company = Company.getInstance();
        company.addTeam(t);
    }
}
