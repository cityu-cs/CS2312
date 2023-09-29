// package CS2312.Lab04.Q03;

import java.util.*;

public class Main {
    static boolean containEven(int n) {
        if (n < 10)
            return n % 2 == 0;
        return ((n % 10) % 2 == 0) || containEven(n / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("input x (-1 to end) :");
            int n = scanner.nextInt();
            if (n == -1)
                return;
            System.out.println(containEven(n));
        }
    }
}
