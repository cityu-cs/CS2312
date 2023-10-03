package CS2312.Lab04.Q08;

import java.util.*;

public class Main {
    static boolean containNonDecreasingDigits(int x) {
        if (x < 10) {
            return true;
        } else {
            int r1 = x % 10;
            int r2 = (x / 10) % 10;
            return (r1 >= r2) && containNonDecreasingDigits(x / 10);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("input x (-1 to end) :");
            int x = scanner.nextInt();
            if (x == -1)
                return;
            System.out.println(containNonDecreasingDigits(x));
        }
    }
}