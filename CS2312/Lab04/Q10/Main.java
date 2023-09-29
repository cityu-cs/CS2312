// package CS2312.Lab04.Q10;

import java.util.Scanner;

public class Main {
    static int tail(int x) {
        return (x < 10) ? 0 : tail(x / 10) * 10 + x % 10;
    }

    static int leftMostDigit(int x) {
        return x < 10 ? x : leftMostDigit(x / 10);
    }

    static boolean areOpposite(int x1, int x2) {
        if (x1 < 10) {
            if (x2 < 10)
                return x1 == x2;
            return false;
        } else if (x2 < 10) {
            return false;
        } else {
            return leftMostDigit(x1) == (x2 % 10) && areOpposite(tail(x1), x2 / 10);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("input 2 integers, separated by a space (\"-1 -1\" to end) :");
            int x1 = scanner.nextInt();
            if (x1 == -1)
                return;
            int x2 = scanner.nextInt();
            System.out.println(areOpposite(x1, x2));
        }
    }
}
