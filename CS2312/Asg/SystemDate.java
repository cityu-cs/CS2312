public class SystemDate extends Day {
    /* Singleton */
    
    private static SystemDate instance = null;

    private SystemDate(String dayString) {
        super(dayString);
    }

    public static void createInstance(String dayString) {
        if (instance == null)
            instance = new SystemDate(dayString);
        else
            System.out.println("Cannot create one more system date instance.");
    }

    public static void setDay(Day dayObject) {
        instance.set(dayObject);
    }

    public static Day getInstance() {
        /*
         * Return a Day class instance to prevent direct access to the instance
         */
        return instance.clone();
    }

    @Override
    public Day clone() {
        return super.clone();
    }
}
