package CS2312.Lab04.Q06;

import java.util.*;

public class Main {
    static int countDigits(int x) {
        return (x < 10) ? 1 : (countDigits(x / 10) + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("input x (-1 to end) :");
            int x = scanner.nextInt();
            if (x == -1)
                return;
            System.out.println(countDigits(x));
        }
    }
}
