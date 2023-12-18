package Final.MID.Q1;

class Result {
	private String s = "Pending";
    public void tell() { System.out.println(s); }
    public void update(String s) { this.s = s; }

    static public void swap(Result r1, Result r2) {
        String temp = r1.s;
        r1.s = r2.s;
        r2.s = temp;
    }

    public void swap(Result r) {
        String temp = this.s;
        this.s = r.s;
        r.s = temp;
    }
}

public class Main{
	public static void main(String[] args) {

		/* Part (a) */		Result r1 = new Result();
							Result r2 = new Result();
							r1.tell(); //Output: Pending
							r2.tell(); //Output: Pending
							r1.update("A+");
							r2.update("Good");		
							r1.tell(); //Output: A+
							r2.tell(); //Output: Good

		/* Part (b) (i) */	Result.swap(r1, r2);
							r1.tell(); //Output: Good
							r2.tell(); //Output: A+

		/* Part (b) (ii) */	r1.swap(r2);
							r1.tell(); //Output: A+
							r2.tell(); //Output: Good
	
    }
}
