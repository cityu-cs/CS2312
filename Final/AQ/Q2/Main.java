package Final.AQ.Q2;

public class Main { 

	public static void main(String [] args) {	

		Staff s1 = new Staff("Helena");
		Staff s2 = new Staff("Tommy");
		Staff s3 = new Staff("Jason");
		Staff s4 = new Staff("Mary");
		Staff s5 = new Staff("Ann");

		s1.setHelper(s2); //Helena's helper is Tommy
		s2.setHelper(s3); //Tommy's helper is Jason; Jason has no helper

		s4.setHelper(s5); //Mary's helper is Ann;  Ann has no helper

		Job a = new Job("Job A");
		Job b = new Job("Job B");
		Job c = new Job("Job C");
		Job d = new Job("Job D");
		Job e = new Job("Job E");
		Job f = new Job("Job F");
	
		s5.assignTask(a); 	// Output [Ann will do Job A]
		s1.assignTask(b); 	// Output [Jason will do Job B]
		s1.assignTask(c); 	// Output [Tommy will do Job C]
		s3.finishJob(); 	// Output [Jason is free now]
		s1.assignTask(d); 	// Output [Jason will do Job D]
		s1.assignTask(e); 	// Output [Helena will do Job E]
		s1.assignTask(f); 	// Output [No manpower]
		s3.finishJob(); 	// Output [Jason is free now]
		s2.finishJob(); 	// Output [Tommy is free now]
		s1.assignTask(f); 	// Output [Jason will do Job F]
	}		
} 

class Job { 
	private String jobCode;
		
	public Job(String jc) {
		jobCode=jc;
	}
	
	public String toString() {return jobCode;}
} 

class Staff {
    private String name;
    private Staff helper;
    private boolean isFree;

    public Staff(String name) {
        this.name = name;
        this.isFree = true;
    }

    public void assignTask(Job job) {

		String worker = tryAssignTask(job);

		if (worker == null)
			System.out.println(
				"No manpower");
		else
			System.out.println(worker + 
				" will do " + job);
	}

    public void setHelper(Staff helper) {
        this.helper = helper;
    }

    private String tryAssignTask(Job job) {
        if (helper != null) {
            String recursiveWorker = helper.tryAssignTask(job);
            if (recursiveWorker != null)
                return recursiveWorker;
        }
        if (isFree) {
            isFree = false;
            return name;
        }
        return null;
    }

    public void finishJob() {
        isFree = true;
        System.out.printf("%s is free now\n", name);
    }
}