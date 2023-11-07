public class Fire extends RecordedCommand {
    private Employee employee;

    @Override
    public void execute(String[] tokens) {
        try {
            if (tokens.length < 2)
                throw new ExInsufficientArguments();
            Company company = Company.getInstance();
            employee = company.findEmployee(tokens[1]);
            company.removeEmployee(employee);
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
