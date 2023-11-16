import java.util.ArrayList;

public class EmployeeTeamRelation {
    private Employee employee;
    private Team team;

    public EmployeeTeamRelation(Employee employee, Team team) {
        this.employee = employee;
        this.team = team;
    }

    public static Team searchTeamByEmployee(ArrayList<EmployeeTeamRelation> EmployeeTeamRelationList, Employee employee) throws ExTeamNotFound {
        for (EmployeeTeamRelation etr : EmployeeTeamRelationList) {
            if (etr.employee.equals(employee)) {
                return etr.team;
            }
        }
        throw new ExTeamNotFound();
    }
}
