package CS2312.Lab05.Q03;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonnelOffice {
    private ArrayList<Employee> employees;

    public PersonnelOffice() {
        employees = new ArrayList<Employee>();
    }

    public void loadEmployeeData(String filename) throws FileNotFoundException {
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
                employees.add(new Manager(id, name, salary, bonus));
            } else {
                employees.add(new Employee(id, name, salary));
            }
        }
    }

    public int getTotal() {
        return employees.size();
    }

    public void report() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            System.out.println(employee);
            totalSalary += employee.getSalary();
        }
        System.out.println("==============================");
        System.out.printf("Total salary expense: %.2f\n", totalSalary);
    }
    
    public void raiseAllSalaries(double percentage) {
        for (Employee employee : employees) {
            employee.raiseSalary(percentage);
        }
    }
}
