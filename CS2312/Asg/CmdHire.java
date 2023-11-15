public class CmdHire extends RecordedCommand {
    private Employee e;

    @Override
    public void execute(String[] tokens) {
        /*
         * Usage: hire <name> <annual leaves: int>
         */
        try {
            if (tokens.length < 3)
                throw new ExInsufficientCommandArguments();
            
            Company company = Company.getInstance();
            if (company.checkEmployeeExists(tokens[1]))
                throw new ExEmployeeAlreadyExists();
            e = new Employee(tokens[1], Integer.parseInt(tokens[2]));
            company.addEmployee(e);

            RecordedCommand.addToUndoList(this);
            RecordedCommand.clearRedoList();
            System.out.println("Done.");
            
        } catch (NumberFormatException e) {
            System.out.println("Wrong number format for annual leaves!");
        } catch (ExInsufficientCommandArguments e) {
            System.out.println(e.getMessage());
        } catch (ExEmployeeAlreadyExists e) {
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
