package CS2312.Lab03.Q03;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Please input the file pathname: ");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();

        Student[] students = Student.createStudentListFromFile(filename);
        Team[] teams = createTeams(students);

        System.out.println("\nGrouping result: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(teams[i].toString());
        }

        Assignment[] assignments = decideTasks(teams, scanner);

        System.out.println("\nSorted listing by tasks: ");
        Assignment.printTaskTeam("Lab05", assignments);
        Assignment.printTaskTeam("Lab06", assignments);
        Assignment.printTaskTeam("Lab07", assignments);
        Assignment.printTaskTeam("Lab08", assignments);
        Assignment.printTaskTeam("Lab09", assignments);
        scanner.close();
    }

    private static Assignment[] decideTasks(Team[] teams, Scanner scanner) {
        Assignment[] assignments = new Assignment[5];
        System.out.println("\nEnter tasks for the teams (Lab05,Lab06,Lab07,Lab08,Lab09): ");
        for (int i = 0; i < 5; i++) {
            System.out.print("Team " + (char)('A' + i) + ": ");
            assignments[i] = new Assignment(teams[i], new Task(scanner.next()));
        }
        return assignments;
    }

    private static Team[] createTeams(Student[] students) {
        Team[] teams = new Team[5];
        for (int i = 0; i < 5; i++) {
            teams[i] = new Team("Team " + (char)('A' + i), Arrays.copyOfRange(students, i * 6, i * 6 + 6));
        }
        return teams;
    }
}
