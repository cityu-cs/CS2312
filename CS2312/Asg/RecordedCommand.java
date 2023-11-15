import java.util.ArrayList;

public abstract class RecordedCommand implements Command {
    private static ArrayList<RecordedCommand> undoList = new ArrayList<>();
    private static ArrayList<RecordedCommand> redoList = new ArrayList<>();

    public abstract void executeThis(String[] tokens);

    @Override
    public final void execute(String[] tokens) {
        /*
         *  Suppose a RecordedCommand subclass called A.
         *  When (new A()).execute() is called, this function will be called.
         *  This is to make sure the undo/redo lists are updated properly.
         *  A cannot override this function, but implements executeThis() instead.
         */
        executeThis(tokens);
        undoList.add(this);
        clearRedoList();
        System.out.println("Done.");
    }

    public abstract void undoThis();

    public abstract void redoThis();

    public static void undoTop() {
        if (undoList.size() == 0) {
            System.out.println("Nothing to undo.");
            return;
        }
        RecordedCommand cmd = undoList.remove(undoList.size() - 1);
        cmd.undoThis();
        redoList.add(cmd);
    }

    public static void redoTop() {
        if (redoList.size() == 0) {
            System.out.println("Nothing to redo.");
            return;
        }
        RecordedCommand cmd = redoList.remove(redoList.size() - 1);
        cmd.redoThis();
        undoList.add(cmd);
    }

    public static void clearRedoList() {
        redoList.clear();
    }
}
