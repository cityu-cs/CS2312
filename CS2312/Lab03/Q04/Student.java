package CS2312.Lab03.Q04;

import java.util.*;
import java.io.*;

public class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public static Student[] createStudentListFromFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        int count = scanner.nextInt();
        scanner.nextLine();
        Student[] students = new Student[count];
        for (int i = 0; i < count; i++) {
            students[i] = new Student(scanner.nextLine());
        }
        return students;
    }
}
