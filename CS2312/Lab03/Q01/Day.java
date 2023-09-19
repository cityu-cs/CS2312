package CS2312.Lab03.Q01;

import java.io.*;
import java.util.Scanner;

public class Day {
	
	private int year;
	private int month;
	private int day;
	
	//Constructor
	public Day(int y, int m, int d) {
		this.year=y;
		this.month=m;
		this.day=d;		
	}

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
	
	// check if a given year is a leap year
	static public boolean isLeapYear(int y)
	{
		if (y%400==0)
			return true;
		else if (y%100==0)
			return false;
		else if (y%4==0)
			return true;
		else
			return false;
	}
	
	// check if y,m,d valid
	static public boolean valid(int y, int m, int d)
	{
		if (m<1 || m>12 || d<1) return false;
		switch(m){
			case 1: case 3: case 5: case 7:
			case 8: case 10: case 12:
					return d<=31; 
			case 4: case 6: case 9: case 11:
					return d<=30; 
			case 2:
					if (isLeapYear(y))
						return d<=29; 
					else
					    return d<=28; 
		}
		return false;
	}

	// Return a string for the day like dd MMM yyyy
	public String toString() {
		
		final String[] MonthNames = {
				"Jan", "Feb", "Mar", "Apr",
				"May", "Jun", "Jul", "Aug",
				"Sep", "Oct", "Nov", "Dec"};
		
		return day+" "+ MonthNames[month-1] + " "+ year;
	}

    static public Day[] createDayListFromFile(String filename) {
        Day[] days = null;
        try {
            Scanner scanner = new Scanner(new File(filename));
            int n = scanner.nextInt();
            days = new Day[n];
            for (int i = 0; i < n; i++) {
                int d = scanner.nextInt();
                int m = scanner.nextInt();
                int y = scanner.nextInt();
                days[i] = new Day(y, m, d);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return days;
    }
}