public class AddSalary implements Command {
    @Override
    public void execute(String[] tokens) {
        Employee e = Company.getInstance().findEmployee(tokens[1]);
        if (e != null) {
            e.addSalary(Integer.parseInt(tokens[2]));
            System.out.println("Done.");
        } else {
            System.out.println("Employee not found");
        }
    }
}
