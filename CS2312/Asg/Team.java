import java.util.ArrayList;

public class Team implements Comparable<Team> {
    private String teamName;
    private Employee head;
    private Day dateSetup;

    public Team(String teamName, Employee head) {
        this.teamName = teamName;
        this.head = head;
        dateSetup = SystemDate.getInstance();
    }

    public String getTeamName() {
        return teamName;
    }

    public String getNameAndMembers() {
        StringBuilder sb = new StringBuilder();
        sb.append(teamName);
        sb.append(" (");
        sb.append(head.getName());
        // TODO: Add other members
        sb.append(")");
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("%-15s%-10s%-13s", teamName, head.getName(), dateSetup);
    }

    @Override
    public int compareTo(Team rhs) {
        return teamName.compareTo(rhs.teamName);
    }

    /* Static methods */

    public static void listTeams(ArrayList<Team> teamList) {
        System.out.printf("%-15s%-10s%-13s\n", "Team Name", "Leader", "Setup Date");
        for (Team t : teamList) {
            System.out.println(t);
        }
    }

    public static Team searchTeam(ArrayList<Team> teamList, String name) throws ExTeamNotFound {
        for (Team t : teamList) {
            if (t.teamName.equals(name)) {
                return t;
            }
        }
        throw new ExTeamNotFound();
    }

    public static boolean checkTeamExists(ArrayList<Team> teamList, String name) {
        for (Team t : teamList) {
            if (t.teamName.equals(name)) {
                return true;
            }
        }
        return false;
    }
}
