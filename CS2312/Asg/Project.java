import java.util.ArrayList;

public class Project implements Comparable<Project> {
    private String projectCode;
    private Day startDay;
    private Day endDay;

    public Project(String projectCode, Day startDay, Day endDay) {
        this.projectCode = projectCode;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    @Override
    public String toString() {
        Company company = Company.getInstance();
        String teamAndMembers = null;
        try {
            Team team = company.searchTeamByProject(this);
            teamAndMembers = team.getNameAndMembers();
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
