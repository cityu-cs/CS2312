package CS2312.Lab06.Q01;

import java.util.*;
import java.io.*;

public class Team{
	
    Member[] members;
	
    public Team(String filepathname) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File(filepathname));
        int n = inFile.nextInt();
        inFile.nextLine();
        members = new Member[n];
        for (int i = 0; i < n; i++) {
            members[i] = new Member(inFile.next());
        }
        inFile.close();
    }
	
    public int getMemberCount() {
        return members.length;
    }
	
	public String getStringOfAllMembers()
	{
		String result = "";
		for (Member member : members)
			result += member.getName();
		result = result.trim(); //.trim() is for removing leading and trailing spaces 
		return result;
	}

	public void printTeamContactMessages()
	{
		String allNames=getStringOfAllMembers(); //e.g. "Helena Peter Mary Paul"
		for (int i = 0; i < members.length; i++) {
			String name_i = members[i].getName(); //e.g. "Helena"
			System.out.print("Dear " + name_i);
			String teammates = allNames.replace(name_i, ""); //e.g. "Peter Mary Paul". Use a trick: create a string based on allNames, but remove name_i: allNames.replace(name_i, "");
			System.out.println(",  please contact your teammates: " + teammates);
		}
	}	
}
