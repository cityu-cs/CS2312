package CS2312.Lab05.Q06;

import java.util.*;
import java.io.*;

public class StatisticsSystem {
    private ArrayList<Counter> counters;

    private static StatisticsSystem theSS = new StatisticsSystem();

    private StatisticsSystem() {
        counters = new ArrayList<Counter>();
    }

    public static StatisticsSystem getInstance() {
        return theSS;
    }

    public static void addCounter(Counter counter) {
        theSS.counters.add(counter);
    }

    public static void countData(String filepathname) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File(filepathname));

        while (inFile.hasNext()) {
            String line = inFile.nextLine();
            Scanner scannerLine = new Scanner(line);
            String id = scannerLine.next();
            String area = scannerLine.next();
            int age = scannerLine.nextInt();
            scannerLine.close();

            Record r = new Record(id, area, age);

            for (Counter counter : theSS.counters) {
                counter.countData(r);
            }
        }
    }

    public static void report() {
        System.out.println("\nStatistics: ");
        System.out.println("============");
        for (Counter counter : theSS.counters) {
            System.out.println(counter);
        }
    }
}
