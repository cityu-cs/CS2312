// package CS2312.Lab06.Q03;

public class RNormalMember implements Role {
    public String getNameAndRole(Member member) {
        return member.getName();
    }

    public String genTeamContactMsg(Team team) {
        return "Please contact your leader: " + team.getLeader().getName();
    }
    
    public String getRoleDescription() {
        return "a normal member";
    }
}
