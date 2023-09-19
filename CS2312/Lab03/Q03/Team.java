// package CS2312.Lab03.Q03;

public class Team {
    private Student[] students;
    private String name;

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
