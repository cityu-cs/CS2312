// package CS2312.Lab06.Q05;

import java.util.*;
import java.io.*;

public class Main{

	public static void main(String [] args) throws FileNotFoundException {	
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please input the file pathname of each team: ");
		String line = in.nextLine();
		Scanner lineScanner = new Scanner(line);

		ArrayList<Team> teams = new ArrayList<>();
		while (lineScanner.hasNext()) {
			String filepathname = lineScanner.next();
			teams.add(new Team(filepathname));
		}

		System.out.println("\nListing of teams:");
		for (int i = 0; i < teams.size(); i++) {
			System.out.printf("[Team %d] %d members: %s \n",
				i + 1, teams.get(i).getMemberCount(), teams.get(i).getStringOfAllMembers()
			);
		}

		System.out.print("\nEnter a name for searching: ");
		String searchName = in.next();
		System.out.print("Result: ");
		boolean flag = false;
		for (int i = 0; i < teams.size(); i++) {
			Member searchResult = teams.get(i).findMember(searchName);
			if (searchResult == null) {
				continue;
			}
			System.out.printf("%s is %s in Team %d\n", searchName, searchResult.getRoleDescription(), i + 1);
			flag = true;
			break;
		}
		if (!flag) {
			System.out.println("Not found");
		}

		in.close();
	}
}
