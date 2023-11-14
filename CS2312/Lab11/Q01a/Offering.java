import java.util.ArrayList;

public class Offering {
    private String semester;

    public Offering(String semester) {
        this.semester = semester;
    }

    public String getSemester() {
        return semester;
    }

    public static Offering getOffering(ArrayList<Offering> offerings, String semester) {
        for (Offering offering : offerings) {
            if (offering.semester.equals(semester)) {
                return offering;
            }
        }
        return null;
    }
}
