import java.util.*;

public abstract class RecordedCommand implements Command {
    public static ArrayList<RecordedCommand> UndoList = new ArrayList<>();
    public static ArrayList<RecordedCommand> RedoList = new ArrayList<>();

    public abstract void execute(String[] tokens);

    public abstract void undoMe();

    public abstract void redoMe();

    static public void addToUndo(RecordedCommand cmd) {
        UndoList.add(cmd);
    }

    static public void addToRedo(RecordedCommand cmd) {
        RedoList.add(cmd);
    }

    static public void clearRedoList() {
        RedoList.clear();
    }

    static public void undoOne() {
        if (UndoList.size() == 0) {
            System.out.println("Nothing to undo.");
            return;
        }
        RecordedCommand cmd = UndoList.remove(UndoList.size() - 1);
        cmd.undoMe();
    }

    static public void redoOne() {
        if (RedoList.size() == 0) {
            System.out.println("Nothing to redo.");
            return;
        }
        RecordedCommand cmd = RedoList.remove(RedoList.size() - 1);
        cmd.redoMe();
    }
}
