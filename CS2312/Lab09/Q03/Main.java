import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
        // Company company = Company.getInstance();
        System.out.print("Please input the file pathname: ");
        Scanner stdin = new Scanner(System.in);
        String filename = stdin.nextLine();
		
		Scanner infile = new Scanner(new File(filename));
		boolean isFirstLine = true;

		while(infile.hasNext()) {
			String line = infile.nextLine();
			if ("".equals(line.trim())) {
				continue;
			}
			System.out.println("\n> " + line);
			// NOTE: | is a special character in regex, so use \| to escape it
			// However, \ is a special character in Java string, so use \\ to escape it
			String[] tokens = line.split("\\|");
			if (tokens[0].equals("startNewDay")) {
				if (isFirstLine) {
					isFirstLine = false;
					(new InitDay()).execute(tokens);
				} else {
					(new StartNewDay()).execute(tokens);
				}
			} else if (tokens[0].equals("hire"))
				(new Hire()).execute(tokens);
			else if (tokens[0].equals("listEmployees"))
				(new ListEmployees()).execute(tokens);
			else if (tokens[0].equals("setupTeam"))
				(new SetupTeam()).execute(tokens);
			else if (tokens[0].equals("listTeams"))
				(new ListTeams()).execute(tokens);
			else if (tokens[0].equals("undo"))
				RecordedCommand.undoOne();
			else if (tokens[0].equals("redo"))
				RecordedCommand.redoOne();
		}
		
		infile.close();
		stdin.close();
	}
}