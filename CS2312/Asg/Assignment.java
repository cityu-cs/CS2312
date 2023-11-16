import java.util.ArrayList;

public class Assignment {
    private Project project;
    private Team team;

    public Assignment(Project project, Team team) {
        this.project = project;
        this.team = team;
    }

    /* Static methods */

    public static Team searchTeamByProject(ArrayList<Assignment> assignmentList, Project project) throws ExTeamNotFound {
        for (Assignment a : assignmentList) {
            if (a.project.equals(project)) {
                return a.team;
            }
        }
        throw new ExTeamNotFound();
    }
}
