// package CS2312.Lab06.Q03;

import java.io.*;
import java.util.*;

public class Team {
    private ArrayList<Member> members;

    public Team(String filename) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File(filename));

        int n = inFile.nextInt();
        members = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = inFile.next();
            char roleType = inFile.next().charAt(0);
            Role role;
            switch (roleType) {
                case 'l': role = new RLeader(); break;
                case 'd': role = new RDisappeared(); break;
                default: role = new RNormalMember();
            }
            members.add(new Member(name, role));
        }
    }

    public int getMemberCount() {
        return members.size();
    }

    public String getStringOfAllMembers() {
        StringBuilder sb = new StringBuilder();
        for (Member m : members) {
            sb.append(' ');
            sb.append(m.getNameAndRole());
        }
        return sb.toString().trim();
    }

    public void printTeamContactMessages() {
        for (Member m : members) {
            System.out.printf("Dear %s, %s\n", m.getName(), m.getRole().genTeamContactMsg(this));
        }
    }

    public Member getLeader() {
        for (Member m : members) {
            if (m.getRole() instanceof RLeader) {
                return m;
            }
        }
        return null;
    }

    public String getStringOfNormalMembers() {
        StringBuilder sb = new StringBuilder();
        for (Member m : members) {
            if (m.getRole() instanceof RNormalMember) {
                sb.append(' ');
                sb.append(m.getNameAndRole());
            }
        }
        return sb.toString().trim();
    }

    public Member findMember(String name) {
        for (Member m : members) {
            if (name.equals(m.getName())) {
                return m;
            }
        }
        return null;
    }

    public void changeLeader(String newLeaderName) {
        Member originalLeader = getLeader();
        Member newLeader = findMember(newLeaderName);
        if (originalLeader != null) {
            originalLeader.setRole(new RNormalMember());
        }
        if (newLeader != null) {
            newLeader.setRole(new RLeader());
        }
    }
}
