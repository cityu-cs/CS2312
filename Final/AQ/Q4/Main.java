package Final.AQ.Q4;

import java.util.ArrayList;

/*
 * Requirements:
 * 1. implement the missing methods in Student and Programme classes
 * 2. implement the Application class
 * 3. implement two interfaces IApply and IAdmit using DIP (Dependency Inversion Principle)
 * 4. model the status of an application using the State pattern
 * DO NOT modify or delete the given code; DO NOT add new fields to the given classes
 */

public class Main { 

	public static void main(String[] args) {
		Student s1 = new Student("Helena");
		Student s2 = new Student("Jason");
		Programme p1 = new Programme("CS"); //Programme of Computer Science
		Programme p2 = new Programme("CM"); //Programme of Creative Media
		
		Application a1 = new Application(s1, p1); 
		Application a2 = new Application(s1, p2);
		Application a3 = new Application(s2, p1);
		Application a4 = new Application(s2, p2);
        // Application(Student, Programme)
		
		p1.offer(a1); 
		p2.offer(a2);
		p1.offer(a3);
        // void Programme.offer(Application)

		s1.accept(a1); 
        // void Student.accept(Application)
		s1.enquire();       	//Output [Accepted(CS==>Helena) Offered(CM==>Helena) ]
		s2.enquire();       	//Output [Offered(CS==>Jason) Pending(CM==>Jason) ] 
        // void Student.enquire()
		
		p1.generateReport(); 	//Output [Accepted(CS==>Helena) Offered(CS==>Jason) ]
		p2.generateReport(); 	//Output [Offered(CM==>Helena) Pending(CM==>Jason) ]
        // void Programme.generateReport()
	}
} 

class Student { 

	private String name;
	private ArrayList<IApply> applications = new ArrayList<>();

	public Student(String name) { this.name = name; }

	public String getName() { return name; }

	public void addApplication(IApply a) {
		applications.add(a);
	}

	/* Your task: Add accept() and enquire() */ 
    public void accept(IApply a) {
        a.accept();
    }

    public void enquire() {
        for (IApply a : applications) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
} 

class Programme { 

	private String name;
	private ArrayList<IAdmit> applications = new ArrayList<>();

	public Programme(String name) { this.name = name; }

	public String getName() { return name; }

	public void addApplication(IAdmit a) {
		applications.add(a);
	}

	/* Your task: Add offer() and generateReport()  */ 
    public void offer(IAdmit a) {
        a.offer();
    }

    public void generateReport() {
        for (IAdmit a : applications) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
} 

/*
 * Thoughts:
 * The use of interfaces allows us to decouple the Application class from the Student and Programme classes
 * Therefore, Student and Programme classes do not rely on Application class
 * 
 * The needs of interfaces root from the fact that the Student and Programme classes need to interact with the Application class differently
 * Student rely on IApply, Programme rely on IAdmit, Application rely on both IApply and IAdmit
 * Note: IApply and IAdmit cannot rely on Application
 * So this is invalid: public void IApply.accept(Application a) -> this will cause Student to rely on Application
 * Instead it can only manipulate the status of Application
 * And this is also invalid: public void IApply.setStatus(Status s) -> this make IApply and IAdmit the same, which does not fulfill the needs
 * that allow Student and Programme handle Application differently
 */

interface IApply {
    public void accept();
}

interface IAdmit {
    public void offer();
}

class Application implements IApply, IAdmit {
    private Student student;
    private Programme programme;
    private Status status;

    @Override
    public String toString() {
        return String.format("%s(%s==>%s)", status, programme.getName(), student.getName());
    }

    Application(Student student, Programme programme) {
        this.student = student;
        this.programme = programme;
        this.status = new SPending();
        student.addApplication(this);
        programme.addApplication(this);
    }

    public void accept() {
        status = new SAccepted();
    }

    public void offer() {
        status = new SOffered();
    }
}

interface Status {
    public String toString();
}

class SPending implements Status {
    @Override
    public String toString() { return "Pending"; }
}

class SOffered implements Status {
    @Override
    public String toString() { return "Offered"; }
}

class SAccepted implements Status {
    @Override
    public String toString() { return "Accepted"; }
}
