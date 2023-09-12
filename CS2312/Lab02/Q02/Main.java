package CS2312.Lab02.Q02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner scannerObj = new java.util.Scanner(System.in);
        int width, height;
        System.out.print("Input the width of the multiplication table (2-10): ");
        width = scannerObj.nextInt();
        System.out.print("Input the height of the multiplication table (2-10): ");
        height = scannerObj.nextInt();
        for (int row = 1; row < height + 1; row++) {
            for (int col = 1; col < width + 1; col++) {
                System.out.printf("%5d|", row * col);
            }
            System.out.println();
        }
    }
}
