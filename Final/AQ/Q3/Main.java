package Final.AQ.Q3;

public class Main { 

	public static void main(String [] args)	{	

		boolean result; 
		BooleanExp exp;
		
		Variable x = new Variable();
		Variable y = new Variable();
		
		// (true and x) or (y and (not x)) 
		exp = new Or(
				new And(new Constant(true), x),
				new And(y, new Not(x)));

		x.assign(false);
		y.assign(true);
		result = exp.evaluate();
		System.out.println(result); //Output [true]
		
		x.assign(false);
		y.assign(false);
		result = exp.evaluate(); 
		System.out.println(result); //Output [false]
		
		exp = new Not(new Or(new Or(x, y),
				new And(new Not(x), new Not(y))));
		x.assign(true);
		y.assign(false);
		result = exp.evaluate();
		System.out.println(result); //Output [false]
	}		
} 

interface BooleanExp {
    public boolean evaluate();
}

class Variable implements BooleanExp {
    private boolean value;

    Variable() {}

    public void assign(boolean value) {
        this.value = value;
    }

    public boolean evaluate() {
        return value;
    }
}

class Constant implements BooleanExp {
    private boolean value;

    Constant(boolean value) {
        this.value = value;
    }

    public boolean evaluate() {
        return value;
    }
}

class Not implements BooleanExp {
    private BooleanExp arg;

    Not(BooleanExp arg) {
        this.arg = arg;
    }

    public boolean evaluate() {
        return !arg.evaluate();
    }
}

class And implements BooleanExp {
    private BooleanExp arg1, arg2;

    And(BooleanExp arg1, BooleanExp arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public boolean evaluate() {
        return arg1.evaluate() && arg2.evaluate();
    }
}

class Or implements BooleanExp {
    private BooleanExp arg1, arg2;

    Or(BooleanExp arg1, BooleanExp arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public boolean evaluate() {
        return arg1.evaluate() || arg2.evaluate();
    }
}
