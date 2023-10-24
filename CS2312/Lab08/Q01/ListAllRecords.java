public class ListAllRecords implements Command {
    @Override
    public void execute(String[] tokens) {
        Company.getInstance().listEmployees();
    }
}
