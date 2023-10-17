// package CS2312.Lab07.Q07;

public abstract class Account {
    private String accountNo;

    public Account(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    @Override
    public String toString() {
        return "Bank A/C Number: " + getAccountNo();
    }

    public abstract double getBalance();
}