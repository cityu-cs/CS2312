package Final.MID.Q3;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			ColorRGB c = new ColorRGB(
					ColorRGB.ask("r: ", sc), ColorRGB.ask("g: ", sc), ColorRGB.ask("b: ", sc));

			System.out.println("Color object created: " + c);

		} catch (InputMismatchException e) {
			System.out.println("Input type mismatch!");
		} catch (OutOfRangeEx e) {
			System.out.println(e.getMessage());
			System.out.printf("Detail: %d is out of range (%s)", e.getValue(), e.getRange());
		}

		sc.close();
	}
}

class ColorRGB {

	private int r, g, b;

	@Override
	public String toString() {
		return r + ", " + g + ", " + b;
	}

    public ColorRGB(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public static int ask(String prompt, Scanner sc) throws OutOfRangeEx {
        System.out.print(prompt);
        int i = sc.nextInt();
        if (i < 0 || i > 255)
            throw new OutOfRangeEx(i, 0, 255);
        return i;
    }
}

class OutOfRangeEx extends Exception {

    private int value, rl, rh;

    public OutOfRangeEx(int value, int rl, int rh) {
        super("Out of range error!");
        this.value = value;
        this.rl = rl;
        this.rh = rh;
    }

    public int getValue() {
        return value;
    }

    public String getRange() {
        return String.format("%d-%d", rl, rh);
    }
}