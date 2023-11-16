public class CmdListTeamMembers implements Command {
    @Override
    public void execute(String[] tokens) {
        /*
         * Usage: listTeamMembers <team name>
         */
        try {
            if (tokens.length < 2) {
                throw new ExInsufficientCommandArguments();
            }
            Company company = Company.getInstance();
            Team team = company.searchTeam(tokens[1]);
            company.listTeamMembers(team);
        } catch (ExInsufficientCommandArguments e) {
            System.out.println(e.getMessage());
        } catch (ExTeamNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}
