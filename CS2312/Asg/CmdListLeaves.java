public class CmdListLeaves implements Command {
    @Override
    public void execute(String[] tokens) {
        /*
         * List leave records of all employees
         * Usage: listLeaves
         *
         * List leave records of a given employee
         * Usage: listLeaves <employee name>
         */
        Company company = Company.getInstance();
        try {
            if (tokens.length == 1) {
                company.listAllLeaveRecords();
            } else {
                company.listLeaveRecordsByEmployee(tokens[1]);
            }
        } catch (ExEmployeeNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}
