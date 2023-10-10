package CS2312.Lab06.Q01;

import java.util.*;
import java.io.*;

public class Main{

	public static void main(String [] args) throws FileNotFoundException
	{	
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please input the file pathname: ");
		String filepathname = in.nextLine();
		
		Team t = new Team(filepathname);
		
		System.out.printf(
			"\nThere are %d members in the team: %s\n\n", 
			t.getMemberCount(), t.getStringOfAllMembers());
		
		System.out.println("Messages for team contacts: ");
		t.printTeamContactMessages();
		
		in.close();
	}
}