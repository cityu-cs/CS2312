// package CS2312.Lab04.Q11;

import java.util.Scanner;

public class Main {
    static int tail(int x) {
        return (x < 10) ? 0 : tail(x / 10) * 10 + x % 10;
    }

    static int leftMostDigit(int x) {
        return x < 10 ? x : leftMostDigit(x / 10);
    }

    static int reverse(int x) {
        if (x < 10)
            return x;
        else
            return reverse(tail(x)) * 10 + leftMostDigit(x);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("input x (-1 to end) :");
            int x = scanner.nextInt();
            if (x == -1)
                return;
            System.out.println(reverse(x));
        }
    }
}
