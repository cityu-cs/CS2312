package CS2312.Lab01.Q02;

public class Day {
    private int year, month, day;
    static final String[] MonthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public Day(int y, int m, int d) {
        this.year = y;
        this.month = m;
        this.day = d;
    }

    public String toString() {
        return day + " " + MonthNames[month - 1] + " " + year;
    }

    static public boolean isLeapYear(int y) {
        return y % 400 == 0 || y % 100 != 0 && y % 4 == 0;
    }

    static public boolean valid(int y, int m, int d) {
        final int[] MonthDays = {31, isLeapYear(y) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (m < 1 || m > 12 || d < 1) {
            return false;
        }
        return d <= MonthDays[m - 1];
    }

    static public boolean isEndOfMonth(int y, int m, int d) {
        final int[] MonthDays = {31, isLeapYear(y) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return d == MonthDays[m - 1];
    }

    static public Day nextDay(int y, int m, int d) {
        if (m == 12 && d == 31) {
            return new Day(y + 1, 1, 1);
        } else if (isEndOfMonth(y, m, d)) {
            return new Day(y, m + 1, 1);
        } else {
            return new Day(y, m, d + 1);
        }
    }
}