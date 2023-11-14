import java.util.ArrayList;

public class Course {
    private String courseCode;
    private ArrayList<Offering> offerings = new ArrayList<>();

    public Course(String courseCode) {
        this.courseCode = courseCode;
    }

    public void addOffering(String semester) {
        offerings.add(new Offering(semester));
    }

    public Offering getOffering(String semester) {
        return Offering.getOffering(offerings, semester);
    }
}
