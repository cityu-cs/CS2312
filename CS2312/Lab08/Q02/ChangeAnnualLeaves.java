public class ChangeAnnualLeaves extends RecordedCommand {
    private Employee employee;
    private int currentAnnualLeaves;
    private int newAnnualLeaves;

    @Override
    public void execute(String[] tokens) {
        Company company = Company.getInstance();
        employee = company.findEmployee(tokens[1]);
        currentAnnualLeaves = employee.getAnnualLeaves();
        newAnnualLeaves = Integer.parseInt(tokens[2]);
        employee.setAnnualLeaves(newAnnualLeaves);
        addToUndo(this);
        clearRedo();
        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        employee.setAnnualLeaves(currentAnnualLeaves);
        addToRedo(this);
    }

    @Override
    public void redoMe() {
        employee.setAnnualLeaves(newAnnualLeaves);
        addToUndo(this);
    }
}
