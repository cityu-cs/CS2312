public class RDisappeared implements Role {
    public String getNameAndRole(Member member) {
        return member.getName() + "[x]";
    }

    public String genTeamContactMsg(Team team) {
        return "When you are back, please contact your leader: " + team.getLeader().getName();
    }

    public String getRoleDescription() {
        return "a disappeared member";
    }
}
