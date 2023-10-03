package CS2312.Lab05.Q05;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonnelOffice {
    private ArrayList<Employee> employees;

    private PersonnelOffice() {
        employees = new ArrayList<Employee>();
    }

    private static PersonnelOffice thePO = new PersonnelOffice();

    public static PersonnelOffice getInstance() {
        return thePO;
    }

    public static void loadEmployeeData(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        while(scanner.hasNext()) {
            String id;
            String name;
            double salary;
            id = scanner.next();
            name = scanner.next();
            salary = scanner.nextDouble();
            if (id.charAt(0) == '9') {
                double bonus;
                bonus = scanner.nextDouble();
                thePO.employees.add(new Manager(id, name, salary, bonus));
            } else {
                thePO.employees.add(new Employee(id, name, salary));
            }
        }
    }

    public static int getTotal() {
        return thePO.employees.size();
    }

    public static void report() {
        double totalSalary = 0;
        for (Employee employee : thePO.employees) {
            System.out.println(employee);
            totalSalary += employee.getSalary();
        }
        System.out.println("==============================");
        System.out.printf("Total salary expense: %.2f\n", totalSalary);
    }
    
    public static void raiseAllSalaries(double percentage) {
        for (Employee employee : thePO.employees) {
            employee.raiseSalary(percentage);
        }
    }
}
