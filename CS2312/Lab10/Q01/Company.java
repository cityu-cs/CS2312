import java.util.*;

public class Company {
    private ArrayList<Employee> allEmployees;
    private static Company instance = new Company();

    private Company() {
        allEmployees = new ArrayList<Employee>();
    }

    public static Company getInstance() {
        return instance;
    }

    public void listEmployees() {
        for (Employee e : allEmployees) {
            System.out.println(e);
        }
    }

    public Employee findEmployee(String name) throws ExEmployeeNotFound {
        for (Employee e : allEmployees) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        throw new ExEmployeeNotFound();
    }

    public void removeEmployee(Employee e) {
        allEmployees.remove(e);
    }

    public void addEmployee(Employee e) {
        allEmployees.add(e);
    }
}
