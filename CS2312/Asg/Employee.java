import java.util.ArrayList;

public class Employee implements Comparable<Employee> {
    private String name;
    private int annualLeaves;

    public Employee(String name, int annualLeaves) {
        this.name = name;
        this.annualLeaves = annualLeaves;
    }

    public String getName() {
        return name;
    }

    public static Employee searchEmployee(ArrayList<Employee> employeeList, String name) throws ExEmployeeNotFound {
        for (Employee e : employeeList) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        throw new ExEmployeeNotFound();
    }

    @Override
    public String toString() {
        return String.format("%s (Entitled Annual Leaves: %d days)", name, annualLeaves);
    }

    @Override
    public int compareTo(Employee rhs) {
        return this.name.compareTo(rhs.name);
    }
}
