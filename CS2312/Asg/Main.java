import java.util.Scanner;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        Scanner filein = null;
		
        System.out.println("Please input the file pathname: ");
        String filename = stdin.nextLine();
		
		try {
			filein = new Scanner(new File(filename));

			String line = filein.nextLine();
			String[] tokens = line.split("\\|");
			System.out.printf("\n> %s\n", line);
			SystemDate.createInstance(tokens[1]);

			while (filein.hasNextLine()) {
				line = filein.nextLine();
				if ("".equals(line.trim())) {
					continue;
				}
				System.out.printf("\n> %s\n", line);
				tokens = line.split("\\|");
				for (int i = 0; i < tokens.length; i++) {
					tokens[i] = tokens[i].trim();
				}

				if (tokens[0].equals("undo"))
					RecordedCommand.undoTop();
				else if (tokens[0].equals("redo"))
					RecordedCommand.redoTop();
				/* SystemDate commands */
				else if (tokens[0].equals("startNewDay"))
					(new CmdStartNewDay()).execute(tokens);
				/* Employee commands */
				else if (tokens[0].equals("hire"))
					(new CmdHire()).execute(tokens);
				else if (tokens[0].equals("listEmployees"))
					(new CmdListEmployees()).execute(tokens);
				/* Team commands */
				else if (tokens[0].equals("setupTeam"))
					(new CmdSetupTeam()).execute(tokens);
				else if (tokens[0].equals("listTeams"))
					(new CmdListTeams()).execute(tokens);
				/* Project commands */
				else if (tokens[0].equals("createProject"))
					(new CmdCreateProject()).execute(tokens);
				else if (tokens[0].equals("assign"))
					(new CmdAssign()).execute(tokens);
				else if (tokens[0].equals("listProjects"))
					(new CmdListProjects()).execute(tokens);
				/* Leave commands */
				else if (tokens[0].equals("takeLeave"))
					(new CmdTakeLeave()).execute(tokens);
				else if (tokens[0].equals("listLeaves"))
					(new CmdListLeaves()).execute(tokens);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} finally {
			if (filein != null)
				filein.close();
			stdin.close();
		}
    }
}