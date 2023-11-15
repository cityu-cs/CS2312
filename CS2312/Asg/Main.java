import java.util.Scanner;
import java.io.*;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner stdin = new Scanner(System.in);
        Scanner filein = null;

        System.out.println("Please input the file pathname: ");
        String filename = stdin.nextLine();
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

			/* undo / redo */
			if (tokens[0].equals("undo"))
				RecordedCommand.undoTop();
			else if (tokens[0].equals("redo"))
				RecordedCommand.redoTop();
			/* system commands */
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
        }

        stdin.close();
        filein.close();
    }
}