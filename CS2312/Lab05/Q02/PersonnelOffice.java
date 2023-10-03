package CS2312.Lab05.Q02;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonnelOffice {
    ArrayList<Employee> employees;

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
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
