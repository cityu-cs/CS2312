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

    public static void list(ArrayList<Team> teams) {
        System.out.printf("%-30s%-10s%-13s\n", "Team Name", "Leader", "Setup Date");
        for (Team team : teams) {
            System.out.println(team);
        }
    }

    @Override
    public String toString() {
        return String.format("%-30s%-10s%-13s", teamName, head.getName(), dateSetup);
    }

    @Override
    public int compareTo(Team rhs) {
        return teamName.compareTo(rhs.teamName);
    }
}
