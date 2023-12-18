package Final.AQ.Q1;

import java.util.*;
import java.io.*;

public class Main { 
	public static void main(String[] args) throws FileNotFoundException {

		Group a = new Group("Ace Team", "D:\\ace.txt");
		Group b = new Group("Best Gang", "D:\\best.txt");
		Group c = new Group("The Crown", "D:\\crown.txt");

		a.show(); // Output [Ace Team: Mary(leader)]
		b.show(); // Output [Best Gang: Brian(leader), Bessy, Bagel, Bill, Bell]
		c.show(); // Output [The Crown: Pinky(leader), Paul]

		if (a.existMember("Paul")) { System.out.println("Paul is found."); } // No output 
		if (b.existMember("Paul")) { System.out.println("Paul is found."); } // No output
		if (c.existMember("Paul")) { System.out.println("Paul is found."); } // Output [Paul is found.]

		Group.changeTeam("Mary", b, c); // Output [No. Mary is not found in Best Gang.]
		Group.changeTeam("Mary", a, b); // Output [No. Mary is the leader in Ace Team.]
		Group.changeTeam("Paul", c, a); // Output [OK]
		Group.changeTeam("Paul", a, b); // Output [OK]
		Person.showHistory("Paul"); // Output [The Crown => Ace Team => Best Gang]
	}
} 

interface Role {
    public String getRole();
}

class RLeader implements Role {
    @Override
    public String getRole() { return "(leader)"; }
}

class RMember implements Role {
    @Override
    public String getRole() { return ""; }
}

class Person {
    private String name;
    private ArrayList<Group> groups = new ArrayList<Group>();
    private Role role;
    static private ArrayList<Person> allPersons = new ArrayList<Person>();

    public Person(String name, Role role) {
        this.name = name;
        this.role = role;
        allPersons.add(this);
    }
    
    public String getName() { return name; }
    public String getNameWithRole() { return name + role.getRole(); }
    public Role getRole() { return role; }
    public void updateGroup(Group group) { groups.add(group); }

    public static void showHistory(String name) {
        for (Person person : allPersons) {
            if (person.name.equals(name)) {
                boolean isFirst = true;
                for (Group group : person.groups) {
                    if (isFirst) {
                        System.out.print(group.getName());
                        isFirst = false;
                    } else {
                        System.out.print(" => " + group.getName());
                    }
                }
                System.out.println();
                return;
            }
        }
    }
}

class Group {
    private String name;
    private ArrayList<Person> members = new ArrayList<Person>();

    public Group(String name, String filename) throws FileNotFoundException {
        this.name = name;
        Scanner infile = new Scanner(new File(filename));
        int n = infile.nextInt();
        for (int i = 0; i < n; i++) {
            String personName = infile.next();
            if (i == 0) {
                Person person = new Person(personName, new RLeader());
                members.add(person);
                person.updateGroup(this);
            } else {
                Person person = new Person(personName, new RMember());
                members.add(person);
                person.updateGroup(this);
            }
        }
        infile.close();
    }

    public String getName() { return name; }

    public void show() {
        System.out.printf("%s: ", name);
        boolean isFirst = true;
        for (Person person : members) {
            if (isFirst) {
                System.out.print(person.getNameWithRole());
                isFirst = false;
            } else {
                System.out.printf(", %s", person.getNameWithRole());
            }
        }
        System.out.println();
    }

    public boolean existMember(String name) {
        for (Person person : members) {
            if (person.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void changeTeam(String name, Group from, Group to) {
        for (int i = 0; i < from.members.size(); i++) { // cannot use foreach - will cause concurrent modification
            Person person = from.members.get(i);
            if (!person.getName().equals(name)) {
                continue;
            }
            if (person.getRole() instanceof RLeader) {
                System.out.printf("No. %s is the leader in %s.\n", name, from.getName());
                return;
            }
            from.members.remove(i);
            to.members.add(person);
            person.updateGroup(to);
            System.out.println("OK");
            return;
        }
        System.out.printf("No. %s is not found in %s.\n", name, from.getName());
    }
}