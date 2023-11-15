public class ExEmployeeHasJoinedAnotherTeam extends Exception {
    public ExEmployeeHasJoinedAnotherTeam() {
        super("Employee has already joined another team.");
    }

    public ExEmployeeHasJoinedAnotherTeam(String message) {
        super(message);
    }

    public ExEmployeeHasJoinedAnotherTeam(String employeeName, String teamName) {
        super(String.format("%s has already joined another team: %s", employeeName, teamName));
    }
}
