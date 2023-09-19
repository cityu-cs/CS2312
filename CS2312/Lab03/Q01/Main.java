package CS2312.Lab03.Q01;

// import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) {
        System.out.println("Please enter the filename: ");
        java.util.Scanner scanner = new Scanner(System.in);
        String filename = scanner.next();

        Day[] days;
        days = Day.createDayListFromFile(filename);
        System.out.println("\nTotally " + days.length + " entries:");
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + ". " + days[i].getDay() + "/" + days[i].getMonth() + "/" + days[i].getYear());
        }
        scanner.close();
    }
}