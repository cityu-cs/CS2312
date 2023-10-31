public class ListTeams implements Command {
    public void execute(String[] tokens) {
        Company company = Company.getInstance();
        company.listTeams();
    }
}
