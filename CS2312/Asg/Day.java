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
         * If offset > 0, return this day advanced by (offset-1) days
         * If offset < 0, return this day retarded by (offset+1) days
         */
        Day newDay = clone();
        if (offset > 1) {
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
        } else if (offset < -1) {
            newDay.day += offset + 1;
            while (newDay.day < 1) {
                newDay.month--;
                if (newDay.month < 1) {
                    newDay.month = 12;
                    newDay.year--;
                }
                newDay.day += getLengthOfMonth(newDay.year, newDay.month);
            }
            return newDay;
        }
        return this;
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
        if (this.year != rhs.year) {
            return this.year - rhs.year;
        }
        if (this.month != rhs.month) {
            return this.month - rhs.month;
        }
        return this.day - rhs.day;
    }

    /* Static methods */

    private static boolean isLeapYear(int y) {
        if (y % 400 == 0) {
            return true;
        }
        if (y % 100 == 0) {
            return false;
        }
        return y % 4 == 0;
    }

    private static int getLengthOfMonth(int y, int m) {
        if (m == 2) {
            return isLeapYear(y) ? 29 : 28;
        }
        if (m <= 7) {
            return m % 2 == 1 ? 31 : 30; // 1, 3, 5, 7 -> 31; 2, 4, 6 -> 30
        }
        return m % 2 == 1 ? 30 : 31; // 8, 10, 12 -> 31; 9, 11 -> 30
    }

    public static int daysBetween(Day from, Day to) {
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
            for (int month = from.month + 1; month <= 12; month++) {
                length += getLengthOfMonth(from.year, month);
            }
            for (int year = from.year + 1; year < to.year; year++) {
                length += isLeapYear(year) ? 366 : 365;
            }
            for (int month = 1; month < to.month; month++) {
                length += getLengthOfMonth(to.year, month);
            }
            length += to.day;
        } else if (from.month != to.month) {
            length += getLengthOfMonth(from.year, from.month) - from.day + 1;
            for (int month = from.month + 1; month < to.month; month++) {
                length += getLengthOfMonth(from.year, month);
            }
            length += to.day;
        } else {
            length = to.day - from.day + 1;
        }
        return length;
    }

    public static boolean checkOverlap(Day from1, Day to1, Day from2, Day to2) {
        if (from1.compareTo(from2) <= 0) {
            return to1.compareTo(from2) >= 0;
        }
        return to2.compareTo(from1) >= 0;
    }

    public static int getOverlapDays(Day from1, Day to1, Day from2, Day to2) {
        /*
         * 1. from1 <= from2 <= to1 <= to2, overlap = daysBetween(from2, to1)
         * 2. from1 <= from2 <= to2 <= to1, overlap = daysBetween(from2, to2)
         * 3. mirror of 1 + 2
         * otherwise, overlap = 0
         */
        if (from1.compareTo(from2) <= 0) { // from1 <= from2
            if (from2.compareTo(to1) <= 0) { // from1 <= from2 <= to1
                if (to1.compareTo(to2) <= 0) { // from1 <= from2 <= to1 <= to2
                    return daysBetween(from2, to1);
                } else { // from1 <= from2 <= to2 < to1
                    return daysBetween(from2, to2);
                }
            } else { // from1 <= to1 < from2 <= to2
                return 0;
            }
        } else {
            if (from1.compareTo(to2) <= 0) {
                if (to2.compareTo(to1) <= 0) {
                    return daysBetween(from1, to2);
                } else {
                    return daysBetween(from1, to1);
                }
            } else {
                return 0;
            }
        }
    }
}
