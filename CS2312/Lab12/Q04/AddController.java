import java.util.*;

public class AddController extends Controller {
    public AddController(List<Course> courseList) {
        super(courseList);
    }

    @Override
    public void process(Course course) {
        if (getCourseList().contains(course)) {
            return;
        }
        for (Course preReq : course.getPreRequisites()) {
            process(preReq);
        }
        getCourseList().add(course);
    }
}
