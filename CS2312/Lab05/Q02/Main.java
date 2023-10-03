package CS2312.Lab05.Q02;

import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);  
        System.out.print("Please enter the filename: ");
        String filepathname = in.next();        
        PersonnelOffice po = new PersonnelOffice();
        po.loadEmployeeData(filepathname);    
        System.out.println("\nTotal count: " + po.getTotal() + " records.\n");      
        po.report();    
        in.close();
    }
}