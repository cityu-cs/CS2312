package Final.L13EX.Q4;

class Animal {
    private AgeGroup group;
    private Type type;
    public Animal(Type type, AgeGroup group) {
        this.type = type;
        this.group = group;
    }
    public void call() {
        group.call(type);
    }
}

public class Main {
    public static void main(String[] args) {
        Animal[] pets = new Animal[6];
        pets[0] = new Animal(new Dog(), new Baby()); // A baby dog is called a puppy.
        pets[1] = new Animal(new Dog(), new Adult());
        pets[2] = new Animal(new Cat(), new Baby()); // A baby cat is called a kitten
        pets[3] = new Animal(new Cat(), new Adult());
        pets[4] = new Animal(new Rabbit(), new Baby()); // A baby rabbit is called a bunny.
        pets[5] = new Animal(new Rabbit(), new Adult());

        for (int i = 0; i < 6; i++)
            pets[i].call();
    }
}

/*
 * Note
 * Checking type is not allowed. This includes instanceof and all reflection methods.
 */

interface AgeGroup {
    void call(Type t);
}

class Baby implements AgeGroup {
    @Override
    public void call(Type t) { t.callAs(this); }
}

class Adult implements AgeGroup {
    @Override
    public void call(Type t) { t.callAs(this); }
}

interface Type {
    void callAs(Baby b);
    void callAs(Adult a);
}

class Dog implements Type {
    @Override
    public void callAs(Baby b) { System.out.println("Puppy"); }
    @Override
    public void callAs(Adult a) { System.out.println("Ddog"); }
}

class Cat implements Type {
    @Override
    public void callAs(Baby b) { System.out.println("Kitten"); }
    @Override
    public void callAs(Adult a) { System.out.println("Cat"); }
}

class Rabbit implements Type {
    @Override
    public void callAs(Baby b) { System.out.println("Bunny"); }
    @Override
    public void callAs(Adult a) { System.out.println("Rabbit"); }
}

/*
 * Part (b) - What is the advantage of using the Visitor pattern?
 * Solution: Visitor pattern separates the algorithm from the object structure.
 * It is implemented via delegation. The algorithm is implemented in the visitor class.
 * In this case, we can add new functionality without modifying the existing classes. This is an example of OCP.
 */
