package CS2312.Lab02.Q05A;

import java.io.*;
import java.util.Scanner;

public class Attendance {

	private int[] students;
	private int[] attendees;

	public Attendance() throws FileNotFoundException {
		students = new int[20];
		attendees = new int[20];
		Scanner sStudents = new Scanner(new File("StudentList.txt"));
		Scanner sAttendees = new Scanner(new File("AttendanceLog.txt"));
		for (int i = 0; i < 20; i++) {
            students[i] = sStudents.nextInt();
        }
        for (int i = 0; i < 20; i++) {
            attendees[i] = sAttendees.nextInt();
        }
		sStudents.close();
		sAttendees.close();
	}

	public boolean isPresent(int id) {
        for (int i = 0; i < 20; i++) {
            if (id == attendees[i]) {
                return true;
            }
        }
        return false;
	}

	public boolean belongToClass(int id) {
        for (int i = 0; i < 20; i++) {
            if (id == students[i]) {
                return true;
            }
        }
        return false;
	}

	public void listAbsentees() {
		System.out.println("List of absentees:");
		int count = 0;
		for (int stuid = 0; stuid < 20; stuid++) {
			boolean paired = false;
			for (int attid = 0; attid < 20; attid++) {
				if (students[stuid] == attendees[attid]) {
					paired = true;
					break;
				}
			}
			if (!paired) {
				count++;
				System.out.println(students[stuid]);
			}
		}
		System.out.printf("Total count: %d\n", count);
	}

	public void listWalkIn() {
		System.out.println("List of walk-in students:");
		for (int attid = 0; attid < 20; attid++) {
			if (attendees[attid] == 0) {
				continue;
			}
			boolean paired = false;
			for (int stuid = 0; stuid < 20; stuid++) {
				if (students[stuid] == attendees[attid]) {
					paired = true;
					break;
				}
			}
			if (!paired) {
				System.out.println(attendees[attid]);
			}
		}
	}
}