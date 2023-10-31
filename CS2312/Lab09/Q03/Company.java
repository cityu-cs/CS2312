import java.util.ArrayList;
import java.util.Collections;

public class Company {
    private ArrayList<Employee> employees;
    private ArrayList<Team> teams;

    private static Company instance = null;

    private Company() {
        employees = new ArrayList<>();
        teams = new ArrayList<>();
    }

    public static Company getInstance() {
        if (instance == null) {
            instance = new Company();
        }
        return instance;
    }

    public void listTeams() {
        Team.list(teams);
    }

    public Employee createEmployee(String name, int annualLeaves) {
        Employee employee = new Employee(name, annualLeaves);
        employees.add(employee);
        Collections.sort(employees);
        return employee;
    }

    public void addEmployee(Employee e) {
        employees.add(e);
        Collections.sort(employees);
    }

    public void removeEmployee(Employee e) {
        employees.remove(e);
    }

    public void listEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public Employee searchEmployee(String name) {
        return Employee.searchEmployee(employees, name);
    }

    public Team createTeam(String teamName, String headName) {
        Employee head = Employee.searchEmployee(employees, headName);
        if (head == null) {
            return null;
        }
        Team team = new Team(teamName, head);
        teams.add(team);
        Collections.sort(teams);
        return team;
    }

    public void addTeam(Team t) {
        teams.add(t);
        Collections.sort(teams);
    }

    public void removeTeam(Team t) {
        teams.remove(t);
    }
}
