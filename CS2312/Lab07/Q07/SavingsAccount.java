// package CS2312.Lab07.Q07;

public class SavingsAccount extends Account {
    private double balance;

    public SavingsAccount(String accountNo, double balance) {
        super(accountNo);
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("Savings A/C Number: %s Balance: $%.2f", getAccountNo(), getBalance());
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
