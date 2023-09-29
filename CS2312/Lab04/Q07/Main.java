// package CS2312.Lab04.Q07;

import java.util.*;

public class Main {
    static int leftMostDigit(int x) {
        return x < 10 ? x : leftMostDigit(x / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("input x (-1 to end) :");
            int x = scanner.nextInt();
            if (x == -1)
                return;
            System.out.println(leftMostDigit(x));
        }
    }
}
