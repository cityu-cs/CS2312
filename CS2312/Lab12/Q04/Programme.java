import java.util.*;

public class Programme {
    private List<Course> courseList;
    private AddController addAgent;
    private DropController dropAgent;

    public Programme() {
        courseList = new LinkedList<Course>();
        addAgent = new AddController(courseList);
        dropAgent = new DropController(courseList);
    }

    public void add(Course course) {
        addAgent.process(course);
        addAgent.printCourses();
    }

    public void drop(Course course) {
        try {
            dropAgent.process(course);
            dropAgent.printCourses();
        } catch (ExCourseControl e) {
            System.out.println(e.getMessage());
        }
    }
}