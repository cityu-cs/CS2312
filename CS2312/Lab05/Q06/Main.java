package CS2312.Lab05.Q06;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the filename: ");
        String filepathname = in.next();
        
        StatisticsSystem ss = StatisticsSystem.getInstance();  
        
        ss.addCounter(new Counter());

        in.nextLine();
        System.out.print("\nEnter the area names (e.g. TaiPo YuenLong WongTaiSin KwunTong): ");
        String line = in.nextLine();
        Scanner scannerLine = new Scanner(line);
        while (scannerLine.hasNext()) {
            ss.addCounter(new AreaCounter(scannerLine.next()));
        }
        scannerLine.close();

        System.out.print("\nEnter the age groups ('-1 -1' to end): ");
        int ageLo = in.nextInt();
        int ageHi = in.nextInt();
        while (ageLo != -1 && ageHi != -1) {
            ss.addCounter(new AgeGroupCounter(ageLo, ageHi));
            System.out.print("Enter the age groups ('-1 -1' to end): ");
            ageLo = in.nextInt();
            ageHi = in.nextInt();
        }

        ss.countData(filepathname);

        ss.report();

        in.close();
    }
}
