public class Hire extends RecordedCommand {
    private Company company;
    private Employee employee;

    @Override
    public void execute(String[] tokens) {
        company = Company.getInstance();
        String name = tokens[1];
        int annualLeaves = Integer.parseInt(tokens[2]);
        employee = company.createEmployee(name, annualLeaves);
        RecordedCommand.addToUndo(this);
        RecordedCommand.clearRedoList();
        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        company.removeEmployee(employee);
        RecordedCommand.addToRedo(this);
    }

    @Override
    public void redoMe() {
        company.addEmployee(employee);
        RecordedCommand.addToUndo(this);
    }
}
