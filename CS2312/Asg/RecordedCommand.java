import java.util.ArrayList;

public abstract class RecordedCommand implements Command {
    private static ArrayList<RecordedCommand> undoList = new ArrayList<>();
    private static ArrayList<RecordedCommand> redoList = new ArrayList<>();

    public abstract void execute(String[] tokens);

    public abstract void undoThis();

    public abstract void redoThis();

    public static void addToUndoList(RecordedCommand cmd) {
        undoList.add(cmd);
    }

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
