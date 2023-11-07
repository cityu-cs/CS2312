public class ChangeAnnualLeaves extends RecordedCommand {
    private Employee employee;
    private int currentAnnualLeaves;
    private int newAnnualLeaves;

    @Override
    public void execute(String[] tokens) {
        try {
            if (tokens.length < 3)
                throw new ExInsufficientArguments();
            Company company = Company.getInstance();
            employee = company.findEmployee(tokens[1]);
            currentAnnualLeaves = employee.getAnnualLeaves();
            newAnnualLeaves = Integer.parseInt(tokens[2]);
            employee.setAnnualLeaves(newAnnualLeaves);
            addToUndo(this);
            clearRedo();
            System.out.println("Done.");
        } catch (NumberFormatException e) {
            System.out.println("Wrong number format.");
        } catch (ExEmployeeNotFound e) {
            System.out.println(e.getMessage());
        } catch (ExInsufficientArguments e) {
            System.out.println(e.getMessage());
        }
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
