// package CS2312.Lab06.Q03;

public class RLeader implements Role {
    public String getNameAndRole(Member member) {
        return member.getName() + "[Leader]";
    }

    public String genTeamContactMsg(Team team) {
        return "Please contact your members: " + team.getStringOfNormalMembers();
    }
}
