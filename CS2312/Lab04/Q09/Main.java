package CS2312.Lab04.Q09;

import java.util.*;

public class Main {
    static int tail(int x) {
        return (x < 10) ? 0 : tail(x / 10) * 10 + x % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("input x (-1 to end) :");
            int x = scanner.nextInt();
            if (x == -1)
                return;
            System.out.println(tail(x));
        }
    }
}
