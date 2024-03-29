import java.util.ArrayList;

public class EmployeeTeamRelation implements Comparable<EmployeeTeamRelation> {
    private Employee employee;
    private Team team;
    private Role role;

    public EmployeeTeamRelation(Employee employee, Team team, Role role) {
        this.employee = employee;
        this.team = team;
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ArrayList<LeaveRecord> leaveRecordList = Company.getInstance().searchLeaveRecords(employee);
        if (leaveRecordList.size() == 0) {
            sb.append("--");
        } else {
            sb.append(leaveRecordList.get(0));
            for (int i = 1; i < leaveRecordList.size(); i++) {
                sb.append(", ").append(leaveRecordList.get(i));
            }
        }
        return String.format("%-10s%-10s%-13s", role, employee.getName(), sb.toString());
    }

    @Override
    public int compareTo(EmployeeTeamRelation rhs) {
        int roleCompare = this.role.toString().compareTo(rhs.role.toString());
        if (roleCompare != 0) {
            return roleCompare;
        }
        return this.employee.compareTo(rhs.employee);
    }

    /* Static methods */

    public static void listTeamMembers(ArrayList<EmployeeTeamRelation> EmployeeTeamRelationList, Team team) {
        ArrayList<EmployeeTeamRelation> result = searchEtrsByTeam(EmployeeTeamRelationList, team);
        System.out.printf("%-10s%-10s%-13s\n", "Role", "Name", "Current / coming leaves");
        for (EmployeeTeamRelation etr : result) {
            System.out.println(etr);
        }
    }

    public static Team searchTeamByEmployee(ArrayList<EmployeeTeamRelation> EmployeeTeamRelationList, Employee employee) throws ExTeamNotFound {
        for (EmployeeTeamRelation etr : EmployeeTeamRelationList) {
            if (etr.employee.equals(employee)) {
                return etr.team;
            }
        }
        throw new ExTeamNotFound();
    }

    public static ArrayList<EmployeeTeamRelation> searchEtrsByTeam(ArrayList<EmployeeTeamRelation> EmployeeTeamRelationList, Team team) {
        ArrayList<EmployeeTeamRelation> result = new ArrayList<>();
        for (EmployeeTeamRelation etr : EmployeeTeamRelationList) {
            if (etr.team.equals(team)) {
                result.add(etr);
            }
        }
        return result;
    }

    public static ArrayList<Employee> searchEmployeesByTeam(ArrayList<EmployeeTeamRelation> EmployeeTeamRelationList, Team team) {
        ArrayList<Employee> result = new ArrayList<>();
        for (EmployeeTeamRelation etr : EmployeeTeamRelationList) {
            if (etr.team.equals(team)) {
                result.add(etr.employee);
            }
        }
        return result;
    }

    public static String formatTeamAndMembers(ArrayList<EmployeeTeamRelation> EmployeeTeamRelationList, Team team) {
        StringBuilder sb = new StringBuilder();
        sb.append(team.getTeamName()).append(" (");
        ArrayList<Employee> result = searchEmployeesByTeam(EmployeeTeamRelationList, team);
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i).getName());
            if (i != result.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
