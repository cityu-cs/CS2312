public class ExLeaveInFinalStage extends Exception {
    public ExLeaveInFinalStage() {
        super("The leave is invalid.");
    }

    public ExLeaveInFinalStage(String message) {
        super(message);
    }

    public ExLeaveInFinalStage(Project p) {
        super(String.format("The leave is invalid.  Reason: Project %s will be in its final stage during %s to %s.",
            p.getProjectCode(), p.getFinalStageStartDay(), p.getFinalStageEndDay()));
    }
}
