package CS2312.Lab02.Q06;

import java.util.Scanner;

public class Main {
/*
/-------------------------------------\ 
|    1|     2     3     4     5     6 | 
|-------------------------------------| 
|    2|     4     6     8    10    12 | 
|    3|     6     9    12    15    18 | 
|    4|     8    12    16    20    24 | 
\-------------------------------------/ 
 */
    public static void main(String[] args) {
        java.util.Scanner scanner = new Scanner(System.in);
        System.out.println("Input the width of the multiplication table (2-10): ");
        int width = scanner.nextInt();
        System.out.println("Input the height of the multiplication table (2-10): ");
        int height = scanner.nextInt();
        // Row 1
        System.out.print("/");
        for (int col = 0; col < width; col++) {
            for (int i = 0; i < 6; i++) {
                System.out.print("-");
            }
        }
        System.out.print("-\\\n");
        // Row 2
        System.out.print("|");
        System.out.printf("%5d|", 1);
        for (int col = 1; col < width; col++) {
            System.out.printf("%6d", (col + 1));
        }
        System.out.print(" |\n");
        // Row 3
        System.out.print("|");
        for (int col = 0; col < width; col++) {
            for (int i = 0; i < 6; i++) {
                System.out.print("-");
            }
        }
        System.out.print("-|\n");
        // Main
        for (int row = 1; row < height; row++) {
            System.out.print("|");
            System.out.printf("%5d|", (row + 1));
            for (int col = 1; col < width; col++) {
                System.out.printf("%6d", (row + 1) * (col + 1));
            }
            System.out.print(" |\n");
        }
        // Last
        System.out.print("\\");
        for (int col = 0; col < width; col++) {
            for (int i = 0; i < 6; i++) {
                System.out.print("-");
            }
        }
        System.out.print("-/\n");
    }
}
