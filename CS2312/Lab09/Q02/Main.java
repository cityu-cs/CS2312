import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
        // Company company = Company.getInstance();
        System.out.print("Please input the file pathname: ");
        Scanner stdin = new Scanner(System.in);
        String filename = stdin.nextLine();
		
		Scanner infile = new Scanner(new File(filename));

		while(infile.hasNext()) {
			String line = infile.nextLine();
			if ("".equals(line.trim())) {
				continue;
			}
			System.out.println("\n> " + line);
			String[] tokens = line.replace("|", " ").split(" ");
			// System.out.println(Arrays.toString(tokens));
			if (tokens[0].equals("startNewDay"))
				(new StartNewDay()).execute(tokens);
			else if (tokens[0].equals("hire"))
				(new Hire()).execute(tokens);
			else if (tokens[0].equals("listEmployees"))
				(new ListEmployees()).execute(tokens);
			else if (tokens[0].equals("undo"))
				RecordedCommand.undoOne();
			else if (tokens[0].equals("redo"))
				RecordedCommand.redoOne();
		}
		
		infile.close();
		stdin.close();
	}
}