package CS2312.Lab05.Q01;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Please enter the filename: ");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.next();
        ArrayList<Employee> employeeList = Employee.createEmployeeList(filename);
        System.out.println();
        System.out.printf("Total count: %d records.\n", employeeList.size());
        for (Employee employee : employeeList) {
            System.out.printf("[%s %s] Salary: %.2f\n", 
                employee.getId(), employee.getName(), employee.getSalary()
            );
        }
    }
}
