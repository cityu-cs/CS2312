public class ExchangeSalaries extends RecordedCommand {
    private Employee employee1;
    private Employee employee2;
    private int salary1;
    private int salary2;

    @Override
    public void execute(String[] tokens) {
        try {
            if (tokens.length < 3)
                throw new ExInsufficientArguments();
            Company company = Company.getInstance();
            employee1 = company.findEmployee(tokens[1]);
            employee2 = company.findEmployee(tokens[2]);
            salary1 = employee1.getSalary();
            salary2 = employee2.getSalary();
            employee1.setSalary(salary2);
            employee2.setSalary(salary1);
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
        employee1.setSalary(salary1);
        employee2.setSalary(salary2);
        addToRedo(this);
    }

    @Override
    public void redoMe() {
        employee1.setSalary(salary2);
        employee2.setSalary(salary1);
        addToUndo(this);
    }
}
