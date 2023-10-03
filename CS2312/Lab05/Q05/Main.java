package CS2312.Lab05.Q05;

import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Please enter the filename: ");
        String filepathname = in.next();
        // PersonnelOffice po = new PersonnelOffice();
        PersonnelOffice po = PersonnelOffice.getInstance();
        po.loadEmployeeData(filepathname);
        System.out.println("\nTotal count: " + po.getTotal() + " records.\n");
        po.report();

        System.out.print("\nEnter percentage for raising salary: ");
        double percentage = in.nextDouble();
        System.out.println();
        po.raiseAllSalaries(percentage);
        po.report();

        in.close();
    }
}