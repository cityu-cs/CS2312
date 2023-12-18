package Final.MID.Q4;

public class Main {

    public static void main(String[] args) {

        Job j1 = new EasyJob("1+1");
        Job j2 = new HardJob("1+2+...99");

        Student peter = Student.createJuniorStudent();
        Student mary = Student.createSeniorStudent();

        peter.take(j1); //output: I can do 1+1
        peter.take(j2); //output: I cannot do 1+2+...99   
        mary.take(j1);  //output: I can do 1+1
        mary.take(j2);  //output: I can do 1+2+...99
    }
}

interface Grade {
    boolean able(Job j);
}

class JuniorGrade implements Grade {
    @Override
    public boolean able(Job j) {
        return j.fit(this);
    }
}

class SeniorGrade implements Grade {
    @Override
    public boolean able(Job j) {
        return j.fit(this);
    }
}

abstract class Job {
    String name;
    
    Job(String name){ this.name = name; }

    @Override
    public String toString() { return name; }

    public abstract boolean fit(JuniorGrade grade);
    public abstract boolean fit(SeniorGrade grade);
}

class EasyJob extends Job {
    public EasyJob(String name){ super(name); }

    @Override
    public boolean fit(JuniorGrade grade) { return true; }

    @Override
    public boolean fit(SeniorGrade grade) { return true; }
}

class HardJob extends Job {
    public HardJob(String name){ super(name); }

    @Override
    public boolean fit(JuniorGrade grade) { return false; }

    @Override
    public boolean fit(SeniorGrade grade) { return true; }
}

class Student {
    private Grade grade;

    private Student(Grade grade){ this.grade = grade; }
    
    static public Student createJuniorStudent() { return new Student(new JuniorGrade()); }
    static public Student createSeniorStudent() { return new Student(new SeniorGrade()); }

    public void take(Job j) {
        if (grade.able(j)) {
            System.out.println("I can do " + j);
        } else {
            System.out.println("I cannot do " + j);
        }
    }
}
