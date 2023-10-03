package CS2312.Lab03.Q03;

public class Assignment {
    private Team team;
    private Task task;

    public Assignment(Team team, Task task) {
        this.team = team;
        this.task = task;
    }

    public String getTaskName() {
        return task.toString();
    }

    public String toString() {
        return task.toString() + " " + team.toString();
    }

    public static void printTaskTeam(String taskName, Assignment[] assignments) {
        for (Assignment assignment : assignments) {
            if (assignment.getTaskName().equals(taskName)) {
                System.out.println(assignment.toString());
            }
        }
    }
}
