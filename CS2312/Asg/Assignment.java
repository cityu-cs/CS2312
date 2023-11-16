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

    public static void checkProjectFinalStage(ArrayList<Assignment> assignmentList, Team team, Day startDay, Day endDay) 
            throws ExLeaveInFinalStage {
        for (Assignment a : assignmentList) {
            if (a.team.equals(team)) {
                if (a.project.checkLeaveOverlapWithFinalStage(startDay, endDay)) {
                    throw new ExLeaveInFinalStage(a.project);
                }
            }
        }
    }

    public static double getProjectCountDuringPeriod(ArrayList<Assignment> assignmentList, Team t,
            Day startDay, Day endDay) {
        double projectCount = 0;
        int totalDays = Day.daysBetween(startDay, endDay);
        for (Assignment a : assignmentList) {
            if (a.team.equals(t)) {
                Day projectStartDay = a.project.getStartDay();
                Day projectEndDay = a.project.getEndDay();
                int overlapDays = Day.getOverlapDays(projectStartDay, projectEndDay, startDay, endDay);
                projectCount += 1.0 * overlapDays / totalDays;
            }
        }
        return projectCount;
    }
}
