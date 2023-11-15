public class CmdListEmployees implements Command {
    @Override
    public void execute(String[] tokens) {
        /*
         * Usage: listEmployees
         */
        Company company = Company.getInstance();
        company.listEmployees();
    }
}
