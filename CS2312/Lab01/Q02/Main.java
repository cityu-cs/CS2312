package CS2312.Lab01.Q02;

public class Main {
    public static void main(String[] args) {
        System.out.print("Please enter the date (eg. \"2013 12 31\"): ");

        java.util.Scanner scannerObj = new java.util.Scanner(System.in);
        int y, m, d;
        y = scannerObj.nextInt();
        m = scannerObj.nextInt();
        d = scannerObj.nextInt();

        if (Day.valid(y, m, d)) {
            Day dayObj = new Day(y, m, d);
            System.out.println("\nYou have entered " + dayObj.toString());
            if (Day.isLeapYear(y)) {
                System.out.println("It is a Leap Year.");
            } else {
                System.out.println("It is NOT a Leap Year.");
            }
            if (Day.isEndOfMonth(y, m, d)) {
                System.out.println("It is the end of a month.");
            } else {
                System.out.println("It is NOT the end of a month.");
            }
            System.out.println("\nThe next day is " + Day.nextDay(y, m, d).toString());
        } else {
            System.out.println("Wrong input.  Program stopped.");
        }

        scannerObj.close();
    }
}
