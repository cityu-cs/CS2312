class ExLeaveOverlapped extends Exception {
    public ExLeaveOverlapped() {
        super("Leave overlapped!");
    }

    public ExLeaveOverlapped(String message) {
        super(message);
    }

    public ExLeaveOverlapped(LeaveRecord lr) {
        super(String.format("Leave overlapped: The leave period %s is found!", lr));
    }
}