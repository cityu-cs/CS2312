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

    public static Employee searchEmployee(ArrayList<Employee> employees, String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public int compareTo(Employee rhs) {
        return name.compareTo(rhs.name);
    }
}
