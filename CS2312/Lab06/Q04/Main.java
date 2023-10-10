// package CS2312.Lab06.Q03;

import java.util.*;
import java.io.*;

public class Main{

	public static void main(String [] args) throws FileNotFoundException {	
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please input the file pathname: ");
		String filepathname = in.nextLine();
		
		Team team = new Team(filepathname);
		
		System.out.printf(
			"\nThere are %d members in the team: %s\n\n", 
			team.getMemberCount(), team.getStringOfAllMembers());
		
		// System.out.println("Messages for team contacts: ");
		// team.printTeamContactMessages();

		System.out.print("Enter new leader: ");
		String newLeaderName = in.next();
		team.changeLeader(newLeaderName);
		System.out.printf("Result: %s\n", team.getStringOfAllMembers());
		
		in.close();
	}
}
