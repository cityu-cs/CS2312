package CS2312.Lab02.Q04;

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

    public void getColSumMax() {
        int maxSum = 0;
        int maxCol = 0;
        int sums[] = new int[WIDTH];
        for (int col = 0; col < WIDTH; col++) {
            for (int row = 0; row < HEIGHT; row++) {
                sums[col] += table[row][col];
            }
            if (sums[col] >= maxSum) {
                maxSum = sums[col];
                maxCol = col;
            }
        }
        System.out.printf("Maximum col sum: %d (col ", maxSum);
        for (int col = 0; col < WIDTH; col++) {
            if (col == maxCol) {
                System.out.printf("%d)\n", col);
                return;
            }
            if (sums[col] == maxSum) {
                System.out.printf("%d,", col);
            }
        }
    }

    public void getRowSumMax() {
        int maxSum = 0;
        int maxRow = 0;
        int sums[] = new int[HEIGHT];
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                sums[row] += table[row][col];
            }
            if (sums[row] >= maxSum) {
                maxSum = sums[row];
                maxRow = row;
            }
        }
        System.out.printf("Maximum row sum: %d (row ", maxSum);
        for (int row = 0; row < HEIGHT; row++) {
            if (row == maxRow) {
                System.out.printf("%d)\n", row);
                return;
            }
            if (sums[row] == maxSum) {
                System.out.printf("%d,", row);
            }
        }
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
