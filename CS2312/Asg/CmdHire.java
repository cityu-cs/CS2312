public class CmdHire extends RecordedCommand {
    private Employee e;

    @Override
    public void executeThis(String[] tokens) {
        /*
         * Usage: hire <name> <annual leaves: int>
         */
        try {
            if (tokens.length < 3)
                throw new ExInsufficientCommandArguments();
            Company company = Company.getInstance();
            e = new Employee(tokens[1], Integer.parseInt(tokens[2]));
            company.addEmployee(e);
        } catch (NumberFormatException e) {
            System.out.println("Wrong number format for annual leaves!");
        } catch (ExInsufficientCommandArguments e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void undoThis() {
        Company company = Company.getInstance();
        company.removeEmployee(e);
    }

    @Override
    public void redoThis() {
        Company company = Company.getInstance();
        company.addEmployee(e);
    }
}
