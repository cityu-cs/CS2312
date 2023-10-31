import java.util.Arrays;

public class SetupTeam extends RecordedCommand {
    private Company company;
    private Team team;

    @Override
    public void execute(String[] tokens) {
        company = Company.getInstance();
        String teamName = tokens[1].trim();
        Employee teamHead = company.searchEmployee(tokens[2].trim());
        team = new Team(teamName, teamHead);
        company.addTeam(team);
        RecordedCommand.addToUndo(this);
        RecordedCommand.clearRedoList();
        System.out.println("Done.");
    }

    @Override
    public void undoMe() {
        company.removeTeam(team);
        RecordedCommand.addToRedo(this);
    }

    @Override
    public void redoMe() {
        company.addTeam(team);
        RecordedCommand.addToUndo(this);
    }
}
