import java.util.ArrayList;
import java.util.Collections;

public class Company {
    /* Singleton */
    
    private ArrayList<Employee> employeeList;
    private ArrayList<Team> teamList;
    private ArrayList<Project> projectList;
    private ArrayList<Assignment> assignmentList;
    private ArrayList<JoinRecord> joinRecordList;
    private ArrayList<LeaveRecord> leaveRecordList;

    private static Company instance = null;

    private Company() {
        employeeList = new ArrayList<>();
        teamList = new ArrayList<>();
        projectList = new ArrayList<>();
        assignmentList = new ArrayList<>();
        joinRecordList = new ArrayList<>();
        leaveRecordList = new ArrayList<>();
    }

    public static Company getInstance() {
        if (instance == null)
            instance = new Company();
        return instance;
    }

    /* Employee methods */

    public void addEmployee(Employee e) {
        employeeList.add(e);
        Collections.sort(employeeList);
    }

    public void removeEmployee(Employee e) {
        employeeList.remove(e);
    }

    public void listEmployees() {
        Employee.listEmployees(employeeList);
    }

    public Employee searchEmployee(String name) throws ExEmployeeNotFound {
        return Employee.searchEmployee(employeeList, name);
    }

    public boolean checkEmployeeExists(String name) {
        return Employee.checkEmployeeExists(employeeList, name);
    }

    /* Team methods */

    public void addTeam(Team t) {
        teamList.add(t);
        Collections.sort(teamList);
    }

    public void removeTeam(Team t) {
        teamList.remove(t);
    }

    public void listTeams() {
        Team.listTeams(teamList);
    }

    public Team searchTeam(String name) throws ExTeamNotFound {
        return Team.searchTeam(teamList, name);
    }

    public boolean checkTeamExists(String name) {
        return Team.checkTeamExists(teamList, name);
    }

    /* Project methods */

    public void addProject(Project p) {
        projectList.add(p);
        Collections.sort(projectList);
    }

    public void removeProject(Project p) {
        projectList.remove(p);
    }

    public void listProjects() {
        Project.listProjects(projectList);
    }

    public Project searchProject(String projectCode) throws ExProjectNotFound {
        return Project.searchProject(projectList, projectCode);
    }

    public boolean checkProjectExists(String projectCode) {
        return Project.checkProjectExists(projectList, projectCode);
    }

    /* Assignment methods */

    public void addAssignment(Assignment a) {
        assignmentList.add(a);
    }

    public void removeAssignment(Assignment a) {
        assignmentList.remove(a);
    }

    public Team searchTeamByProject(Project p) throws ExTeamNotFound {
        return Assignment.searchTeamByProject(assignmentList, p);
    }

    /* JoinRecord methods */

    public void addJoinRecord(JoinRecord jr) {
        joinRecordList.add(jr);
    }

    public void removeJoinRecord(JoinRecord jr) {
        joinRecordList.remove(jr);
    }

    public Team searchTeamByEmployee(Employee e) throws ExTeamNotFound {
        return JoinRecord.searchTeamByEmployee(joinRecordList, e);
    }

    /* LeaveRecord methods */

    public void addLeaveRecord(LeaveRecord lr) {
        leaveRecordList.add(lr);
        Collections.sort(leaveRecordList);
    }

    public void removeLeaveRecord(LeaveRecord lr) {
        leaveRecordList.remove(lr);
    }

    public ArrayList<LeaveRecord> searchLeaveRecordByEmployee(Employee e) {
        return LeaveRecord.searchLeaveRecordByEmployee(leaveRecordList, e);
    }

    public void listLeaveRecordByEmployee(String name) throws ExEmployeeNotFound {
        Employee e = searchEmployee(name);
        LeaveRecord.listLeaveRecordByEmployee(leaveRecordList, e);
    }

    public void listAllLeaveRecords() {
        LeaveRecord.listAllLeaveRecords(leaveRecordList, employeeList);
    }

    public LeaveRecord getOverlapLeaveRecord(Employee e, Day startDay, Day endDay) {
        return LeaveRecord.getOverlapLeaveRecord(leaveRecordList, e, startDay, endDay);
    }

    public int getAnnualLeaveBalance(Employee e) {
        return LeaveRecord.getAnnualLeaveBalance(leaveRecordList, e);
    }
}