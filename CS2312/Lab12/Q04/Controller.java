import java.util.*;

public abstract class Controller {
    private List<Course> courseList;

    public Controller(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void printCourses() {
        System.out.print("Course List: ");
        for (Course course : courseList) {
            System.out.printf("[%s] ", course);
        }
        System.out.println();
    }

    public abstract void process(Course course) throws ExCourseControl;
}
