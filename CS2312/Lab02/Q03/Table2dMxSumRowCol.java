package CS2312.Lab02.Q03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Table2dMxSumRowCol {
    private static final int HEIGHT = 10;
    private static final int WIDTH = 10;

    private int[][] table = new int[HEIGHT][WIDTH];

    private void set(int row, int col, int value) {
        table[row][col] = value;
    }

    public Table2dMxSumRowCol(String filePath) {
        try {
            java.util.Scanner scanner = new java.util.Scanner(new File(filePath));
            while (scanner.hasNext()) {
                set(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }

    public int getColSumMax() {
        int maxSum = 0;
        for (int col = 0; col < WIDTH; col++) {
            int sum = 0;
            for (int row = 0; row < HEIGHT; row++) {
                sum += table[row][col];
            }
            if (sum > maxSum || col == 0) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public int getRowSumMax() {
        int maxSum = 0;
        for (int row = 0; row < HEIGHT; row++) {
            int sum = 0;
            for (int col = 0; col < WIDTH; col++) {
                sum += table[row][col];
            }
            if (sum > maxSum || row == 0) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public void print() {
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                System.out.printf("%5d", table[row][col]);
            }
            System.out.println();
        }
    }
}
