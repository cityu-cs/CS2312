package Final.AY1920A.Q1;

public class Main {
    public static void main(String[] args) {
        Value v1 = new Value(100); // Statement S1
        Value v2 = new MultiValue(300, v1); // Statement S2
        Value v3 = new MultiValue(500, v2); // Statement S3

        v1.advance(); // Statement S4
        v2.advance(); // Statement S5
        v3.advance(); // Statement S6

        v3.tellValue(); // Statement S7
    }
}

class Value {
    private int i;
    public Value(int i) {this.i = i;}
    public void advance() {i *= 2;}
    public void tellValue() {System.out.println(i);}
}

class MultiValue extends Value {
    private Value child = null;
    public MultiValue(int i, Value child) {
        super(i);
        this.child = child;
    }

    @Override
    public void advance() {
        super.advance();
        if (child != null) child.advance();
    }

    @Override
    public void tellValue() {
        super.tellValue();
        if (child != null) child.tellValue();
    }
}

/*
 * (a) What is the output of the program?
 * 
 * 1000
 * 1200
 * 800
 * 
 * (b) Choose one statement in S1-S7 to explain Polymorphism.
 * 
 * Polymorphism means a superclass object variable can refer to any different superclass or subclass object (as long as the class is not abstract). This is checked at compile time.
 * In S2, the Value object variable v2 refers to a MultiValue object.
 * Note: Dynamic binding means the method to be invoked is based on the actual object type. This is checked at runtime.
 * In S5, since v2 refers to a MultiValue object, the advance() method in MultiValue is invoked.
 * 
 * (c) Explain upcasting and downcasting. Among S1-S7, which statement(s) involve upcasting and which statement(s) involve downcasting?
 * Using the classes Value and MultiValue, write an example involving explicit casting.
 * 
 * Upcasting means transforming a subclass object to a superclass object. This is implicit casting.
 * Downcasting means transforming a superclass object to a subclass object. This is explicit casting.
 * S2 and S3 involve upcasting, where subclass MultiValue objects are treated as superclass Value objects.
 * Explicit casting example:
 * MultiValue mv1 = (MultiValue) v1;
 * It transforms the superclass Value object to a subclass MultiValue object.
 */