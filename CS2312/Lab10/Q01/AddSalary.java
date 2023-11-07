public class AddSalary extends RecordedCommand {
    private Employee employee;
    private int salary;

    @Override
    public void execute(String[] tokens) {
        try {
            if (tokens.length < 3)
                throw new ExInsufficientArguments();
            Company company = Company.getInstance();
            employee = company.findEmployee(tokens[1]);
            salary = Integer.parseInt(tokens[2]);
            employee.addSalary(salary);
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
        employee.addSalary(-salary);
        addToRedo(this);
    }

    @Override
    public void redoMe() {
        employee.addSalary(salary);
        addToUndo(this);
    }
}