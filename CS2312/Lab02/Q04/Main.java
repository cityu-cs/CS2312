package CS2312.Lab02.Q04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Please input the file pathname: ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String filePath = scanner.nextLine();
        Table2dMxSumRowCol table = new Table2dMxSumRowCol(filePath);
        table.print();
        table.getRowSumMax();
        table.getColSumMax();
    }
}
