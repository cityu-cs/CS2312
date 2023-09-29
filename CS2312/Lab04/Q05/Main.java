// package CS2312.Lab04.Q05;

import java.util.*;

public class Main {
    static boolean containDigit(int x, int d) {
        if (x < 10) {
            return x == d;
        } else {
            return x % 10 == d || containDigit(x / 10, d);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("input x and d, separated by a space (\"-1 -1\" to end) :");
            int x = scanner.nextInt();
            if (x == -1)
                return;
            int d = scanner.nextInt();
            System.out.println(containDigit(x, d));
        }
    }
}
