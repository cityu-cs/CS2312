package CS2312.Lab03.Q04;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the file pathname: ");
        Student[] students = Student.createStudentListFromFile(scanner.next());
        int studentCount = students.length;
        System.out.println("\nTotal number of students: " + studentCount);
        System.out.println("\nEnter the number of teams: ");
        int teamCount = scanner.nextInt();
        if (studentCount % teamCount != 0) {
            System.out.println("\nWrong input - It is not a factor of " + studentCount + ".");
            scanner.close();
            return;
        }

        Team[] teams = getTeams(students, teamCount);
        System.out.println("\nGrouping result:");
        for (Team team : teams) {
            System.out.println(team.toString());
        }

        System.out.print("\nEnter " + teamCount + " task names (eg. \"Lab05 Lab06 Lab07 ..\"):");
        String[] taskNames = new String[teamCount];
        for (int i = 0; i < teamCount; i++) {
            taskNames[i] = scanner.next();
        }

        Assignment[] assignments = getAssignments(teams, taskNames, scanner);
        System.out.println("\nSorted listing by tasks:");
        for (int i = 0; i < teamCount; i++) {
            Assignment.printAssignment(taskNames[i], assignments);
        }
    }

    private static Team[] getTeams(Student[] students, int teamCount) {
        Team[] teams = new Team[teamCount];
        int perTeam = students.length / teamCount;
        for (int i = 0; i < teamCount; i++) {
            teams[i] = new Team(
                "Team " + (char)('A' + i),
                Arrays.copyOfRange(students, perTeam * i, perTeam * (i + 1))
            );
        }
        return teams;
    }

    private static Assignment[] getAssignments(Team[] teams, String[] taskNames, Scanner scanner) {
        System.out.print("\nEnter tasks for the teams (");
        System.out.print(taskNames[0]);
        int taskCount = taskNames.length;
        for (int i = 1; i < taskCount; i++) {
            System.out.print("," + taskNames[i]);
        }
        System.out.println("):");
        Assignment[] assignments = new Assignment[taskCount];
        for (int i = 0; i < taskCount; i++) {
            System.out.print("Team " + (char)('A' + i) + ": ");
            assignments[i] = new Assignment(teams[i], new Task(scanner.next()));
        }
        return assignments;
    }
}
