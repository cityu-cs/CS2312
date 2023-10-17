// package CS2312.Lab07.Q07;

import java.io.*;
import java.util.*;

public class BankSystem {
    ArrayList<Account> accounts = new ArrayList<Account>();

    private static BankSystem instance = new BankSystem();

    public static BankSystem getInstance() {
        return instance;
    }

    public static void createAccountsFromFile(String filepathname) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File(filepathname));
        while (inFile.hasNextLine()) {
            String[] line = inFile.nextLine().split(" ");
            switch(line[0].charAt(0)) {
                case '0': case '1': case '2': case '3': case '4': case '5':
                    instance.accounts.add(new SavingsAccount(line[0], Double.parseDouble(line[1])));
                    break;
                case '6': case '7': case '8':
                    instance.accounts.add(new CreditCardAccount(line[0], Double.parseDouble(line[1]), Double.parseDouble(line[2])));
                    break;
                case '9':
                    instance.accounts.add(new PowerAdvantageAccount(
                        line[0],
                        (SavingsAccount) findAccount(line[1]),
                        (CreditCardAccount) findAccount(line[2])
                    ));
                    break;
            }
        }
        inFile.close();
    }

    public static Account findAccount(String accountNo) {
        for (Account account : instance.accounts) {
            if (account.getAccountNo().equals(accountNo)) {
                return account;
            }
        }
        return null;
    }
}
