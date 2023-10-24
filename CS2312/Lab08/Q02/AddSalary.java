public class AddSalary extends RecordedCommand {
    private Employee employee;
    private int salary;

    @Override
    public void execute(String[] tokens) {
        Company company = Company.getInstance();
        employee = company.findEmployee(tokens[1]);
        salary = Integer.parseInt(tokens[2]);
        employee.addSalary(salary);
        addToUndo(this);
        clearRedo();
        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        employee.addSalary(-salary);
        addToRedo(this);
    }

    @Override
    public void redoMe() {
        employee.addSalary(salary);
        addToUndo(this);
    }
}