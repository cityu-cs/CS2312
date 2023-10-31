public class SystemDate extends Day {
    private static SystemDate instance = null;

    private SystemDate(String dayString) {
        super(dayString);
    }

    public static SystemDate getInstance() {
        return instance;
    }

    public static void setDay(Day day) {
        instance = new SystemDate(day.toString());
    }

    public static void createTheInstance(String dayString) {
        if (instance == null) {
            instance = new SystemDate(dayString);
        } else {
            System.out.println("Cannot create one more system date instance.");
        }
    }
}
