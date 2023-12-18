package Final.L13EX.Q3;

public class Main {
public static void main(String [] args) 
    {
        Sentence[] s = new Sentence[3]; 
        s[0] = new Do(new Re(new Mi(new Sentence())));
        s[1] = new Do(new Mi(new Do(new Mi(new Sentence()))));
        s[2] = new Re(new Mi(new Fa(new Fa(new Mi(new Re(new Fa(new Sentence())))))));
        for (int i=0; i<3; i++)
        s[i].print();
    }
}

class Sentence {
    public void print() { System.out.println("!!!"); }
}

/* trivial solution
class Do extends Sentence {
    Sentence s;
    public Do(Sentence s) { this.s = s; }
    @Override
    public void print() { System.out.print("do "); s.print(); }
}

class Re extends Sentence {
    Sentence s;
    public Re(Sentence s) { this.s = s; }
    @Override
    public void print() { System.out.print("re "); s.print(); }
}

class Mi extends Sentence {
    Sentence s;
    public Mi(Sentence s) { this.s = s; }
    @Override
    public void print() { System.out.print("mi "); s.print(); }
}

class Fa extends Sentence {
    Sentence s;
    public Fa(Sentence s) { this.s = s; }
    @Override
    public void print() { System.out.print("fa "); s.print(); }
}
*/

/*
 * Decorator pattern solution
 */

class Decorator extends Sentence {
    Sentence s;
    public Decorator(Sentence s) { this.s = s; }
    @Override
    public void print() { s.print(); }
}

class Do extends Decorator {
    public Do(Sentence s) { super(s); }
    @Override
    public void print() { System.out.print("do "); super.print(); }
}

class Re extends Decorator {
    public Re(Sentence s) { super(s); }
    @Override
    public void print() { System.out.print("re "); super.print(); }
}

class Mi extends Decorator {
    public Mi(Sentence s) { super(s); }
    @Override
    public void print() { System.out.print("mi "); super.print(); }
}

class Fa extends Decorator {
    public Fa(Sentence s) { super(s); }
    @Override
    public void print() { System.out.print("fa "); super.print(); }
}

/*
 * Part (b) - What are the advantages of using the decorator pattern?
 * Solution: Decorator pattern follows OCP. If we want to add a new sentence, we simply write a new class that extends Decorator.
 * Decorator pattern is more flexible than static inheritance. You can add functionality to some objects without affecting other objects of the same class.
 */
