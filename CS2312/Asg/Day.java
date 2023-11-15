public class Day implements Cloneable, Comparable<Day> {
    private int year;
    private int month;
    private int day;
    private static String MONTH_NAMES = "JanFebMarAprMayJunJulAugSepOctNovDec";

    public Day(int y, int m, int d) {
        this.year = y;
        this.month = m;
        this.day = d;
    }

    public Day(String dayString) {
        set(dayString);
    }

    public void set(String dayString) {
        /*
         * Parse a date string of dd-MMM-yyyy format
         * No exception handling because the input date is guaranteed to be valid
         */
        String tokens[] = dayString.split("-");
        this.day = Integer.parseInt(tokens[0]);
        this.month = MONTH_NAMES.indexOf(tokens[1]) / 3 + 1;
        this.year = Integer.parseInt(tokens[2]);
    }

    public void set(Day rhs) {
        this.year = rhs.year;
        this.month = rhs.month;
        this.day = rhs.day;
    }

    public Day advance(int offset) {
        /*
         * Return a new Day object that is (offset - 1) days after this
         */
        Day newDay = clone();
        newDay.day += offset - 1;
        while (newDay.day > getLengthOfMonth(newDay.year, newDay.month)) {
            newDay.day -= getLengthOfMonth(newDay.year, newDay.month);
            newDay.month++;
            if (newDay.month > 12) {
                newDay.month = 1;
                newDay.year++;
            }
        }
        return newDay;
    }

    @Override
    public String toString() {
        return String.format("%d-%s-%04d", day, MONTH_NAMES.substring((month - 1) * 3, month * 3), year);
    }

    @Override
    public Day clone() {
        try {
            return (Day) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public int compareTo(Day rhs) {
        if (this.year != rhs.year)
            return this.year - rhs.year;
        if (this.month != rhs.month)
            return this.month - rhs.month;
        return this.day - rhs.day;
    }

    static private boolean isLeapYear(int y) {
        if (y % 400 == 0)
            return true;
        if (y % 100 == 0)
            return false;
        return y % 4 == 0;
    }

    static private int getLengthOfMonth(int y, int m) {
        if (m == 2)
            return isLeapYear(y) ? 29 : 28;
        if (m <= 7)
            return m % 2 == 1 ? 31 : 30; // 1, 3, 5, 7 -> 31; 2, 4, 6 -> 30
        return m % 2 == 1 ? 30 : 31; // 8, 10, 12 -> 31; 9, 11 -> 30
    }

    static public int getInterval(Day from, Day to) {
        /*
         * Calculate the length of the interval between two days, both inclusive
         */
        int length = 0;
        if (from.compareTo(to) > 0) {
            Day tmp = from;
            from = to;
            to = tmp;
        }
        if (from.year != to.year) {
            length += getLengthOfMonth(from.year, from.month) - from.day + 1;
            for (int month = from.month + 1; month <= 12; month++)
                length += getLengthOfMonth(from.year, month);
            for (int year = from.year + 1; year < to.year; year++)
                length += isLeapYear(year) ? 366 : 365;
            for (int month = 1; month < to.month; month++)
                length += getLengthOfMonth(to.year, month);
            length += to.day;
        } else if (from.month != to.month) {
            length += getLengthOfMonth(from.year, from.month) - from.day + 1;
            for (int month = from.month + 1; month < to.month; month++)
                length += getLengthOfMonth(from.year, month);
            length += to.day;
        } else {
            length = to.day - from.day + 1;
        }
        return length;
    }
}
