import java.util.*;

public abstract class RecordedCommand implements Command {
    public static Stack<RecordedCommand> undoStack = new Stack<RecordedCommand>();
    public static Stack<RecordedCommand> redoStack = new Stack<RecordedCommand>();

    public abstract void execute(String[] tokens);

    public abstract void undoMe();

    public abstract void redoMe();

    // protected can be accessed by subclasses
    protected static void addToUndo(RecordedCommand cmd) {
        undoStack.push(cmd);
    }

    protected static void addToRedo(RecordedCommand cmd) {
        redoStack.push(cmd);
    }

    protected static void clearRedo() {
        redoStack.clear();
    }

    public static void undoOne() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }
        RecordedCommand cmd = undoStack.pop();
        cmd.undoMe();
    }

    public static void redoOne() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }
        RecordedCommand cmd = redoStack.pop();
        cmd.redoMe();
    }
}