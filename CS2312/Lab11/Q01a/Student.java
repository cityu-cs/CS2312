import java.util.ArrayList;

public class Student {
    private String id;
    private ArrayList<Offering> studiedOfferings = new ArrayList<>();

    public Student(String id) {
        this.id = id;
    }

    public void takeCourse(Course course, String semester) {
        studiedOfferings.add(course.getOffering(semester));
    }

    public boolean hasTaken(Offering offering) {
        return studiedOfferings.contains(offering);
    }

    public boolean hasBeenClassmateOf(Student other) {
        for (Offering offering : studiedOfferings) {
            if (other.hasTaken(offering)) {
                return true;
            }
        }
        return false;
    }
}