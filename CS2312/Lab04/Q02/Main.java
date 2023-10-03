package CS2312.Lab04.Q02;

import java.util.*;

class Main {
    static int getLargestDigit(int n) {
        if (n < 10)
            return n;
        return Math.max(n % 10, getLargestDigit(n / 10));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input n: ");
        int n = scanner.nextInt();
        System.out.println(getLargestDigit(n));
    }
}