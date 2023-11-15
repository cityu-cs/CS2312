public class CmdListTeams implements Command {
    @Override
    public void execute(String[] tokens) {
        /*
         * Usage: listTeams
         */
        Company company = Company.getInstance();
        company.listTeams();
    }
}
