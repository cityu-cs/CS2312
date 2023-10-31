public class InitDay implements Command {
    public void execute(String[] tokens) {
        SystemDate systemDate = SystemDate.getInstance();
        systemDate.createTheInstance(tokens[1]);
    }
}
