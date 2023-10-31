public class ListEmployees implements Command {
    public void execute(String[] tokens) {
        Company company = Company.getInstance();
        company.listEmployees();
    }
}
