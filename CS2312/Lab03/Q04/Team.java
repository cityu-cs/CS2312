package CS2312.Lab03.Q04;

public class Team {
    private String name;
    private Student[] students;

    public Team(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public String toString() {
        String result = name + ":";
        for (int i = 0; i < students.length; i++) {
            result += " [" + students[i].toString() + "]";
        }
        return result;
    }

    public String getName() {
        return name;
    }
}
