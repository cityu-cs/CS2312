public class Day implements Cloneable {
    private int year;
    private int month;
    private int day;
    private static final String MONTH_NAMES = "JanFebMarAprMayJunJulAugSepOctNovDec";

    public Day(int y, int m, int d) {
        year = y;
        month = m;
        day = d;
    }

    public Day(String dayString) {
        set(dayString);
    }

    public void set(String dayString) { // DD-MMM-YYYY
        String[] tokens = dayString.split("-");
        day = Integer.parseInt(tokens[0]);
        month = MONTH_NAMES.indexOf(tokens[1]) / 3 + 1;
        year = Integer.parseInt(tokens[2]);
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

    static public boolean isLeapYear(int y) {
        if (y % 400 == 0) {
            return true;
        } else if (y % 100 == 0) {
            return false;
        } else if (y % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    static public boolean isValidDate(int y, int m, int d) {
        if (m < 1 || m > 12 || d < 1) {
            return false;
        }
        switch (m) {
            case 4: case 6: case 9: case 11:
                return d <= 30;
            case 2:
                return isLeapYear(y) ? d <= 29 : d <= 28;
            default:
                return d <= 31;
        }
    }
}