package Final.AY1920A.Q2;

class Counter {
    private int count=0;
    private Controller k;
    public Counter(Controller k) {this.k=k;}
    public void tick() {k.tick(this);}
    public void increment(int incr) {
        count+=incr;
        System.out.printf("Increment = %d,  result = %d\n",  
            incr, count);
    }
}

public class Main {
    public static void main(String[] args) {
        Counter counter1 = new Counter(new Simple());
        counter1.tick(); //Output: Increment = 1,  result = 1
        counter1.tick(); //Output: Increment = 1,  result = 2
        counter1.tick(); //Output: Increment = 1,  result = 3
        counter1.tick(); //Output: Increment = 1,  result = 4
        counter1.tick(); //Output: Increment = 1,  result = 5
        Counter counter2 = new Counter(new Advanced());
        counter2.tick(); //Output: Increment = 1,  result = 1
        counter2.tick(); //Output: Increment = 2,  result = 3
        counter2.tick(); //Output: Increment = 3,  result = 6
        counter2.tick(); //Output: Increment = 4,  result = 10
        counter2.tick(); //Output: Increment = 5,  result = 15
    }
}

/*
 * (a) Complete the program.
 */

interface Controller {
    void tick(Counter c);
}

class Simple implements Controller {
    private int incr;

    public Simple() { incr = 1; }

    @Override
    public void tick(Counter c) {
        c.increment(incr);
    }
}

class Advanced implements Controller {
    private int incr;

    public Advanced() { incr = 1; }

    @Override
    public void tick(Counter c) {
        c.increment(incr);
        incr++;
    }
}

/*
 * (b) State 2 reasons for using an abstract class instead of an interface.
 * 
 * 1. If we want to provide the default implementation of some methods, we can use an abstract class, because abstract classes can have non-abstract methods.
 * 2. If we want to save common fields, we can use an abstract class, because abstract classes can have fields.
 * 3. If we want to provide a constructor, we can use an abstract class, because abstract classes can have constructors.
 * 
 * Note: Abstract Class vs Interface
 * See [Topic5.pdf] for more details.
 */