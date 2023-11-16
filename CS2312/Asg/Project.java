import java.util.ArrayList;

public class Project implements Comparable<Project> {
    private String projectCode;
    private Day startDay;
    private Day endDay;
    private static final int FINAL_STAGE_DURATION = 5;

    public Project(String projectCode, Day startDay, Day endDay) {
        this.projectCode = projectCode;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public Day getStartDay() {
        return startDay;
    }

    public Day getEndDay() {
        return endDay;
    }

    public Day getFinalStageStartDay() {
        if (Day.daysBetween(startDay, endDay) <= FINAL_STAGE_DURATION) {
            return startDay;
        }
        return endDay.advance(-FINAL_STAGE_DURATION);
    }

    public boolean checkLeaveOverlapWithFinalStage(Day leaveStartDay, Day leaveEndDay) {
        return Day.checkOverlap(leaveStartDay, leaveEndDay, getFinalStageStartDay(), endDay);
    }

    @Override
    public String toString() {
        Company company = Company.getInstance();
        String teamAndMembers = null;
        try {
            Team team = company.searchTeamByProject(this);
            teamAndMembers = company.formatTeamAndMembers(team);
        } catch (ExTeamNotFound e) {
            teamAndMembers = "--";
        }
        return String.format("%-9s%-13s%-13s%-13s", projectCode, startDay, endDay, teamAndMembers);
    }

    @Override
    public int compareTo(Project rhs) {
        return projectCode.compareTo(rhs.projectCode);
    }

    /* Static methods */

    public static void listProjects(ArrayList<Project> projectList) {
        System.out.printf("%-9s%-13s%-13s%-13s\n", "Project", "Start Day", "End Day", "Team");
        for (Project p : projectList) {
            System.out.println(p);
        }
    }

    public static Project searchProject(ArrayList<Project> projectList, String code) throws ExProjectNotFound {
        for (Project p : projectList) {
            if (p.projectCode.equals(code)) {
                return p;
            }
        }
        throw new ExProjectNotFound();
    }

    public static boolean checkProjectExists(ArrayList<Project> projectList, String code) {
        for (Project p : projectList) {
            if (p.projectCode.equals(code)) {
                return true;
            }
        }
        return false;
    }
}
