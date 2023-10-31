import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		SystemDate.createTheInstance("01-Jan-2022");

		Company co = Company.getInstance();
		co.createEmployee("Bob", 30);
		co.createEmployee("John", 30);
		co.createEmployee("Grace", 30);

		co.createTeam("Customer Relationship Team", "Bob");
		co.createTeam("Strategic Planning Team", "John");

		SystemDate.getInstance().set("01-Feb-2022"); // set system date to 1/2/2022
		co.createTeam("Clerical Support Team", "Grace");

		co.listTeams();
	}
}