import java.util.ArrayList;

public class Team implements Comparable<Team> {
    private String teamName;
    private Employee head;
    private Day dateSetup;

    public Team(String teamName, Employee head) {
        this.teamName = teamName;
        this.head = head;
        dateSetup = SystemDate.getInstance().clone();
    }

    public static void listTeams(ArrayList<Team> teamList) {
        System.out.printf("%-15s%-10s%-13s\n", "Team Name", "Leader", "Setup Date");
        for (Team team : teamList) {
            System.out.println(team);
        }
    }

    @Override
    public String toString() {
        return String.format("%-15s%-10s%-13s", teamName, head.getName(), dateSetup);
    }

    @Override
    public int compareTo(Team rhs) {
        return teamName.compareTo(rhs.teamName);
    }
}
