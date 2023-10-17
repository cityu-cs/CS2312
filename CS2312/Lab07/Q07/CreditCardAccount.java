// package CS2312.Lab07.Q07;

public class CreditCardAccount extends Account {
    private double balance;
    private double creditLimit;

    public CreditCardAccount(String accountNo, double balance, double creditLimit) {
        super(accountNo);
        this.balance = balance;
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return String.format("Credit Card A/C Number: %s Balance: $%.2f Credit Limit: $%.2f", getAccountNo(), getBalance(), creditLimit);
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
