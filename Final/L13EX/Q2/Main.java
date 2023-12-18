package Final.L13EX.Q2;

public class Main {
    public static void main(String[] args) {
        Cook c1 = new SteamCook();
        Cook c2 = new CurryCook();

        c1.cook(new Fish()); // "steamed fish"
        c2.cook(new Chicken()); // "chicken in curry"
        c1.cook(new Chicken()); // "steamed chicken"
        c2.cook(new Fish()); // "fish in curry"
    }
}

interface Cook {
    void cook(Food f);
}

class SteamCook implements Cook {
    @Override
    public void cook(Food f) {
        System.out.println("steamed " + f.getName());
    }
}

class CurryCook implements Cook {
    @Override
    public void cook(Food f) {
        System.out.println(f.getName() + " in curry");
    }
}

interface Food {
    String getName();
}

class Fish implements Food {
    @Override
    public String getName() { return "fish"; }
}

class Chicken implements Food {
    @Override
    public String getName() { return "chicken"; }
}

/*
 * Part (b) - Discuss why the following change violates OCP (Open-Closed Principle).
public class Cook {
    private int cooking_type; // cooking type: 1 - steam, 2 - curry
    public void cook(..) {
        ..  // depends on the cooking type, output the result 
        }
    }
 * Solution: If we want to add a new cooking type, we need to modify the Cook class.
 * e.g. If add 3 - fry, we need to add a new field and modify the cook() method.
 * However, OCP states that classes should be open for extension but closed for modification.
 * In the original code, if we want to add fry, we simply write another class that implements Cook.
 * Therefore, the change violates OCP.
 */
