import java.util.*;

public class Course {
    private String name;
    private List<Course> preRequisites;

    public Course(String name) {
        this.name = name;
        preRequisites = new LinkedList<Course>();
    }

    @Override
    public String toString() {
        return name;
    }

    public void addPreReq(Course course) {
        if (!preRequisites.contains(course)) {
            preRequisites.add(course);
        }
    }

    public List<Course> getPreRequisites() {
        return preRequisites;
    }
}