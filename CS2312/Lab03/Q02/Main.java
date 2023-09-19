package CS2312.Lab03.Q02;

// import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) {
        System.out.println("Please enter the filename: ");
        java.util.Scanner scanner = new Scanner(System.in);
        String filename = scanner.next();

        Day[] days;
        days = Day.createDayListFromFile(filename);
        System.out.println("\nValid dates: ");
        for (int i = 0; i < days.length; i++) {
            if (days[i].valid()) {
                System.out.println(days[i].toString());
            }
        }
        System.out.println("\nInvalid dates: ");
        for (int i = 0; i < days.length; i++) {
            if (!days[i].valid()) {
                System.out.println(days[i].shortDate());
            }
        }
        scanner.close();
    }
}