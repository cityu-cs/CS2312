package Final.L13EX.Q1;

public class Main {
    public static void main(String[] args) {
        Decider d1 = new WeatherDecider();
        Decider d2 = new BudgetDecider();

        goHiking(d1); // "Go hiking only if no rain."
        goHiking(d2); // "Go hiking anytime!"
        goShopping(d1); // "Go shopping anytime!"
        goShopping(d2); // "Go shopping if we have money."
    }

    private static void goHiking(Decider d) {
        d.decideHiking();
    }

    private static void goShopping(Decider d) {
        d.decideShopping();
    }
}

interface Decider {
    void decideHiking();
    void decideShopping();
}

class WeatherDecider implements Decider {
    public void decideHiking() {
        System.out.println("Go hiking only if no rain.");
    }

    public void decideShopping() {
        System.out.println("Go shopping anytime!");
    }
}

class BudgetDecider implements Decider {
    public void decideHiking() {
        System.out.println("Go hiking anytime!");
    }

    public void decideShopping() {
        System.out.println("Go shopping if we have money.");
    }
}

/*
 * Part (b): Use the code to explain upcasting and dynamic binding.
 * 
 * Upcasting means treating a subclass object as a superclass object. 
 * In code, goHiking(d1) converts the WeatherDecider object d1 into a Decider object.
 * 
 * Dynamic binding means that if a subclass overrides a superclass method, the method to be called is determined at runtime.
 * In code, goHiking(d1) calls Decider.decideHiking(). Since d1 is a WeatherDecider object, it is dynamically bound to WeatherDecider.decideHiking().
 */
