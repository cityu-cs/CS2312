package Final.AY1920A.Q4;

public class Main {
    public static void main(String[] args) {
        Barber b = Barber.getInstance();
        (new CustomerEarly("Mr YANG")).call(b);
        (new CustomerEarly("Ms TANG")).call(b);
        (new Customer("Ms WONG")).call(b, 1500);
        (new CustomerEarly("Ms CHAN")).call(b);

        b.list(); // output the customer list
    }
}

class Customer {
    private String name;
    private int serviceTime;
    public Customer(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name + " (" + this.serviceTime + ")";
    }
    public void call(Barber b, int t) {
        serviceTime = t;
        b.markTime(this, t);
    }
    
    protected void setServiceTime(int t) {
        serviceTime = t;    
    }
}

/*
 * Background: A barber shop has only one barber. He accepts up to 6 customers per day, at time slot 1100, 1200, through 1600.
 * There are 2 types of customers: early and appointment. Early customers is served as early as possible. Appointment customers is served at the given time.
 * Expected output:
 * Mr YANG (1100)
 * Ms TANG (1200)
 * Ms CHAN (1300)
 * Ms WONG (1500)
 * (a) Complete the program. Implement Barber class using Singleton pattern.
 */

class CustomerEarly extends Customer {
    public CustomerEarly(String name) {
        super(name);
    }

    public void call(Barber b) {
        int t = b.getEarliestTime();
        if (t != -1) {
            super.setServiceTime(t);
            b.markTime(this, t);
        }
    }
}

class Barber {
    private static Barber instance = null;
    private Customer[] clist = new Customer[6];

    private Barber() { }

    public static Barber getInstance() {
        if (instance == null) {
            instance = new Barber();
        }
        return instance;
    }

    public int getEarliestTime() {
        for (int i = 0; i < 6; i++) {
            if (clist[i] == null) {
                return 1100 + i * 100;
            }
        }
        return -1;
    }

    public void markTime(Customer c, int t) {
        int slot = (t - 1100) / 100;
        if (clist[slot] == null) {
            clist[slot] = c;
        }
    }

    public void list() {
        for (int i = 0; i < 6; i++) {
            if (clist[i] != null) {
                System.out.println(clist[i]);
            }
        }
    }
}

/*
 * (b) Explain how the Barber class achieves the purpose of Singleton pattern.
 * 
 * The Singleton pattern ensures that only one instance of the class is created.
 * 1. The constructor of Barber is private, so a new instance cannot be created outside the class. Additionally, getInstance() guarantees that only one instance is created.
 * 2. The getInstance() method is static, which provides a global point of access to the instance.
 */
