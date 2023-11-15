public class CmdListProjects implements Command {
    @Override
    public void execute(String[] cmdParts) {
        /*
         * Usage: listProjects
         */
        Company company = Company.getInstance();
        company.listProjects();
    }
}
