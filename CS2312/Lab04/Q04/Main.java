// package CS2312.Lab04.Q04;

import java.util.*;

public class Main {
    static void showDigitsReverse(int x) {
        if (x < 10)
            System.out.println(x);
        else {
            System.out.print((x % 10) + " ");
            showDigitsReverse(x / 10);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("input x (-1 to end) :");
            int n = scanner.nextInt();
            if (n == -1)
                return;
            showDigitsReverse(n);
        }
    }
}
