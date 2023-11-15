import java.util.ArrayList;

public class JoinRecord {
    private Employee employee;
    private Team team;

    public JoinRecord(Employee employee, Team team) {
        this.employee = employee;
        this.team = team;
    }

    public static Team searchTeamByEmployee(ArrayList<JoinRecord> joinRecordList, Employee employee) throws ExTeamNotFound {
        for (JoinRecord jr : joinRecordList) {
            if (jr.employee.equals(employee)) {
                return jr.team;
            }
        }
        throw new ExTeamNotFound();
    }
}
