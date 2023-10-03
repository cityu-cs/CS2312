package CS2312.Lab05.Q05;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Employee {
    private String id;
    private String name;
    private double salary;

    public Employee() {}

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return String.format("[%s %s] Salary: %.2f", id, name, salary);
    }

    public static ArrayList<Employee> createEmployeeList(String filename) throws FileNotFoundException {
        ArrayList<Employee> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filename));
        while(scanner.hasNext()) {
            String id = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            arrayList.add(new Employee(id, name, salary));
        }
        return arrayList;
    }

    public void raiseSalary(double percentage) {
        salary *= (1 + percentage / 100);
    }
}
