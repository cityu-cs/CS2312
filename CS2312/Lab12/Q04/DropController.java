import java.util.*;

public class DropController extends Controller {
    public DropController(List<Course> courseList) {
        super(courseList);
    }

    @Override
    public void process(Course course) throws ExPrerequisiteForAnother, ExCourseNotFound {
        if (getCourseList().contains(course)) {
            for (Course c : getCourseList()) {
                if (c.getPreRequisites().contains(course)) {
                    throw new ExPrerequisiteForAnother(String.format(
                        "Cannot drop %s (Required for %s)",
                        course, c
                    ));
                }
            }
            getCourseList().remove(course);
        } else {
            throw new ExCourseNotFound(String.format(
                "Cannot drop %s (Course doesn't exist in the list)",
                course
            ));
        }
    }
}
