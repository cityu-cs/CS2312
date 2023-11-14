import java.util.ArrayList;

public class Offering {
    private String semester;
    private ArrayList<Student> students = new ArrayList<>();

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

    public void addStudent(Student student) {
        students.add(student);
    }

    public String printSemesterAndStudents() {
        StringBuilder sb = new StringBuilder();
        sb.append(semester);
        sb.append(":");
        for (Student student : students) {
            sb.append(" ");
            sb.append(student);
        }
        return sb.toString();
    }
}
