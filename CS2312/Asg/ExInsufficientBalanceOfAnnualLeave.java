class ExInsufficientBalanceOfAnnualLeave extends Exception {
    public ExInsufficientBalanceOfAnnualLeave() {
        super("Insufficient balance of annual leave.");
    }

    public ExInsufficientBalanceOfAnnualLeave(String message) {
        super(message);
    }

    public ExInsufficientBalanceOfAnnualLeave(int balance) {
        super(String.format("Insufficient balance of annual leave. %d days left only!", balance));
    }
}