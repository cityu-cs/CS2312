// package CS2312.Lab07.Q07;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        BankSystem bank = BankSystem.getInstance();

        System.out.print("Please input the file pathname: ");
        String filepathname = scanner.nextLine();
        bank.createAccountsFromFile(filepathname);

        System.out.print("\nInput an account number to search: ");
        String accountNo = scanner.nextLine();
        System.out.print("\n[Result]\n");
        Account account = bank.findAccount(accountNo);
        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("The account is not found.");
        }
    }
}
