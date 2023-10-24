public class Fire extends RecordedCommand {
    private Employee employee;

    @Override
    public void execute(String[] tokens) {
        Company company = Company.getInstance();
        employee = company.findEmployee(tokens[1]);
        company.removeEmployee(employee);
        addToUndo(this);
        clearRedo();
        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        Company company = Company.getInstance();
        company.addEmployee(employee);
        addToRedo(this);
    }

    @Override
    public void redoMe() {
        Company company = Company.getInstance();
        company.removeEmployee(employee);
        addToUndo(this);
    }
}
