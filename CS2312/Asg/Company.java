import java.util.ArrayList;
import java.util.Collections;

public class Company {
    /*
     * Singleton class
     */
    private ArrayList<Employee> employeeList;
    private ArrayList<Team> teamList;

    private static Company instance = null;

    private Company() {
        employeeList = new ArrayList<>();
        teamList = new ArrayList<>();
    }

    public static Company getInstance() {
        if (instance == null)
            instance = new Company();
        return instance;
    }

    /*
     * Employee methods
     */

    public void addEmployee(Employee e) {
        employeeList.add(e);
    }

    public void removeEmployee(Employee e) {
        employeeList.remove(e);
    }

    public void listEmployees() {
        Collections.sort(employeeList);
        for (Employee e : employeeList) {
            System.out.println(e);
        }
    }

    public Employee searchEmployee(String name) throws ExEmployeeNotFound {
        return Employee.searchEmployee(employeeList, name);
    }

    /*
     * Team methods
     */

    public void addTeam(Team t) {
        teamList.add(t);
    }

    public void removeTeam(Team t) {
        teamList.remove(t);
    }

    public void listTeams() {
        Collections.sort(teamList);
        Team.listTeams(teamList);
    }
}