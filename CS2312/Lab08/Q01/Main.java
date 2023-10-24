import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Company company = Company.getInstance();
        System.out.print("Please input the file pathname: ");
        Scanner stdin = new Scanner(System.in);
        String filename = stdin.nextLine();

        Scanner infile = new Scanner(new File(filename));
        int cnt = infile.nextInt();
        while (cnt-- > 0) {
            String name = infile.next();
            int salary = infile.nextInt();
            int annualLeaves = infile.nextInt();
            Employee e = new Employee(name, salary, annualLeaves);
            company.addEmployee(e);
        }

        while (infile.hasNext()) {
            String command = infile.nextLine();
            if (command.equals("")) {
                continue;
            }
            System.out.println("\n> " + command);
            String[] tokens = command.split(" ");
            if (tokens[0].equals("list"))
                (new ListAllRecords()).execute(tokens);
            else if (tokens[0].equals("addSalary"))
                (new AddSalary()).execute(tokens);
        }

        stdin.close();
        infile.close();
    }
}