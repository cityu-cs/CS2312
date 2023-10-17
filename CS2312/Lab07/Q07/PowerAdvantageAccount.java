// package CS2312.Lab07.Q07;

public class PowerAdvantageAccount extends Account {
    private SavingsAccount savingsAC;
    private CreditCardAccount creditCardAC;

    public PowerAdvantageAccount(String accountNo, SavingsAccount savingsAC, CreditCardAccount creditCardAC) {
        super(accountNo);
        this.savingsAC = savingsAC;
        this.creditCardAC = creditCardAC;
    }

    @Override
    public String toString() {
        return String.format("Power Advantage A/C Number: %s Balance: $%.2f\n 1.%s\n 2.%s",
                getAccountNo(), getBalance(), savingsAC.toString(), creditCardAC.toString());
    }

    @Override
    public double getBalance() {
        return savingsAC.getBalance() - creditCardAC.getBalance();
    }
}
