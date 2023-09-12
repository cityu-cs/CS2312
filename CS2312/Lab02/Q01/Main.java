package CS2312.Lab02.Q01;

public class Main {
    public static final int WIDTH = 12;
    public static final int HEIGHT = 8;

    public static void count_0_to_100(int[][] A) {
        int count = 0;
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                if (A[row][col] >= 0 && A[row][col] <= 100) {
                    count++;
                }
            }
        }
        System.out.println("The count is: " + count);
    }

    public static void main(String[] args) {
        int[][] val = new int[HEIGHT][WIDTH];

        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                val[row][col] = ((col + 13) * (row + 29)) % 413 - 139;
            }
        }

        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++)
                System.out.printf("%5d", val[row][col]);
            System.out.println();
        }

        count_0_to_100(val);
    }
}