import java.util.ArrayList;
import java.util.Collections;

public class Company {
    
    private ArrayList<Employee> employeeList;
    private ArrayList<Team> teamList;
    private ArrayList<Project> projectList;
    private ArrayList<Assignment> assignmentList;
    private ArrayList<EmployeeTeamRelation> EmployeeTeamRelationList;
    private ArrayList<LeaveRecord> leaveRecordList;

    /* Singleton */
    private static Company instance = null;

    private Company() {
        employeeList = new ArrayList<>();
        teamList = new ArrayList<>();
        projectList = new ArrayList<>();
        assignmentList = new ArrayList<>();
        EmployeeTeamRelationList = new ArrayList<>();
        leaveRecordList = new ArrayList<>();
    }

    public static Company getInstance() {
        if (instance == null) {
            instance = new Company();
        }
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

    public void checkProjectFinalStage(Employee e, Day startDay, Day endDay) throws ExLeaveInFinalStage {
        try {
            Team t = searchTeamByEmployee(e);
            Assignment.checkProjectFinalStage(assignmentList, t, startDay, endDay);
        } catch (ExTeamNotFound ex) {
            return; // no team means no project
        }
    }

    /* EmployeeTeamRelation methods */

    public void addEmployeeTeamRelation(EmployeeTeamRelation etr) {
        EmployeeTeamRelationList.add(etr);
        Collections.sort(EmployeeTeamRelationList);
    }

    public void addEmployeeTeamRelations(ArrayList<EmployeeTeamRelation> etrList) {
        EmployeeTeamRelationList.addAll(etrList);
        Collections.sort(EmployeeTeamRelationList);
    }

    public void removeEmployeeTeamRelation(EmployeeTeamRelation etr) {
        EmployeeTeamRelationList.remove(etr);
    }

    public void removeEmployeeTeamRelations(ArrayList<EmployeeTeamRelation> etrList) {
        EmployeeTeamRelationList.removeAll(etrList);
    }

    public void listTeamMembers(Team t) {
        EmployeeTeamRelation.listTeamMembers(EmployeeTeamRelationList, t);
    }

    public Team searchTeamByEmployee(Employee e) throws ExTeamNotFound {
        return EmployeeTeamRelation.searchTeamByEmployee(EmployeeTeamRelationList, e);
    }

    public ArrayList<EmployeeTeamRelation> searchEtrsByTeam(Team t) {
        return EmployeeTeamRelation.searchEtrsByTeam(EmployeeTeamRelationList, t);
    }

    public String formatTeamAndMembers(Team team) {
        return EmployeeTeamRelation.formatTeamAndMembers(EmployeeTeamRelationList, team);
    }

    /* LeaveRecord methods */

    public void addLeaveRecord(LeaveRecord lr) {
        leaveRecordList.add(lr);
        Collections.sort(leaveRecordList);
    }

    public void removeLeaveRecord(LeaveRecord lr) {
        leaveRecordList.remove(lr);
    }

    public ArrayList<LeaveRecord> searchLeaveRecords(Employee e) {
        return LeaveRecord.searchLeaveRecords(leaveRecordList, e);
    }

    public void listLeaveRecordsByEmployee(String name) throws ExEmployeeNotFound {
        Employee e = searchEmployee(name);
        LeaveRecord.listLeaveRecordsByEmployee(leaveRecordList, e);
    }

    public void listAllLeaveRecords() {
        LeaveRecord.listAllLeaveRecords(leaveRecordList, employeeList);
    }

    public void checkOverlapLeaveRecords(Employee e, Day startDay, Day endDay) throws ExLeaveOverlapped {
        LeaveRecord.checkOverlapLeaveRecords(leaveRecordList, e, startDay, endDay);
    }

    public int getAnnualLeaveBalance(Employee e) {
        return LeaveRecord.getAnnualLeaveBalance(leaveRecordList, e);
    }

    /* System methods */

    public void suggestProjectTeam(Project project) {
        System.out.printf("During the period of project %s (%s to %s):\n",
                project.getProjectCode(), project.getStartDay(), project.getEndDay());
        System.out.print("  Average manpower (m) and count of existing projects (p) of each team: \n");
        ArrayList<Double> predictedLoadingFactorList = new ArrayList<>();
        double minPredictedLoadingFactor = Double.MAX_VALUE;

        for (int i = 0; i < teamList.size(); i++) {
            Team t = teamList.get(i);
            ArrayList<Employee> teamMembers = EmployeeTeamRelation.searchEmployeesByTeam(EmployeeTeamRelationList, t);
            double p = Assignment.getProjectCountDuringPeriod(assignmentList, t, project.getStartDay(), project.getEndDay());
            double m = LeaveRecord.getManpowerDuringPeriod(leaveRecordList, teamMembers, project.getStartDay(), project.getEndDay());
            
            double predictedLoadingFactor = (1.0 + p) / m;
            predictedLoadingFactorList.add(predictedLoadingFactor);
            if (predictedLoadingFactor < minPredictedLoadingFactor) {
                minPredictedLoadingFactor = predictedLoadingFactor;
            }

            System.out.printf("    %s: m=%.2f workers, p=%.2f projects\n", t.getTeamName(), m, p);
        }
        System.out.printf("  Projected loading factor when a team takes this project %s:\n", project.getProjectCode());
        for (int i = 0; i < teamList.size(); i++) {
            System.out.printf("    %s: (p+1)/m = %.2f\n", teamList.get(i).getTeamName(), predictedLoadingFactorList.get(i));
        }
        for (int i = 0; i < teamList.size(); i++) {
            if (predictedLoadingFactorList.get(i) == minPredictedLoadingFactor) {
                System.out.printf("Conclusion: %s should be assigned to %s for best balancing of loading\n",
                        project.getProjectCode(), teamList.get(i).getTeamName());
            }
        }
    }
}