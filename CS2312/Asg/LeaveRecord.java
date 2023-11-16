import java.util.ArrayList;

public class LeaveRecord implements Comparable<LeaveRecord> {
    private Employee employee;
    private Day startDay;
    private Day endDay;

    public LeaveRecord(Employee employee, Day startDay, Day endDay) {
        this.employee = employee;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    @Override
    public String toString() {
        return String.format("%s to %s", startDay, endDay);
    }

    @Override
    public int compareTo(LeaveRecord rhs) {
        if (this.employee.equals(rhs.employee))
            return this.startDay.compareTo(rhs.startDay);
        else
            return this.employee.compareTo(rhs.employee);
    }

    /* Static methods */

    public static ArrayList<LeaveRecord> searchLeaveRecordByEmployee(ArrayList<LeaveRecord> leaveRecordList, Employee employee) {
        ArrayList<LeaveRecord> result = new ArrayList<>();
        for (LeaveRecord lr : leaveRecordList) {
            if (lr.employee.equals(employee)) {
                result.add(lr);
            }
        }
        return result;
    }

    public static ArrayList<LeaveRecord> searchCurrentFutureLeaveRecordByEmployee(ArrayList<LeaveRecord> leaveRecordList, Employee employee) {
        Day systemDate = SystemDate.getInstance();
        ArrayList<LeaveRecord> result = new ArrayList<>();
        for (LeaveRecord lr : leaveRecordList) {
            if (lr.employee.equals(employee) && lr.endDay.compareTo(systemDate) >= 0) {
                result.add(lr);
            }
        }
        return result;
    }

    public static void listLeaveRecordByEmployee(ArrayList<LeaveRecord> leaveRecordList, Employee employee) {
        System.out.printf("%s: ", employee.getName());
        ArrayList<LeaveRecord> result = searchCurrentFutureLeaveRecordByEmployee(leaveRecordList, employee);
        if (result.size() == 0) {
            System.out.println("--");
        } else {
            System.out.print(result.get(0));
            for (int i = 1; i < result.size(); i++) {
                System.out.printf(", %s", result.get(i));
            }
            System.out.println();
        }
    }

    public static void listAllLeaveRecords(ArrayList<LeaveRecord> leaveRecordList, ArrayList<Employee> employeeList) {
        for (Employee e : employeeList) {
            listLeaveRecordByEmployee(leaveRecordList, e);
        }
    }

    public static LeaveRecord getOverlapLeaveRecord(ArrayList<LeaveRecord> leaveRecordList, Employee employee, Day startDay, Day endDay) {
        for (LeaveRecord lr : leaveRecordList) {
            if (lr.employee.equals(employee)) {
                if (lr.startDay.compareTo(endDay) <= 0 && startDay.compareTo(lr.endDay) <= 0)
                    return lr;
            }
        }
        return null;
    }

    public static int getAnnualLeaveBalance(ArrayList<LeaveRecord> leaveRecordList, Employee employee) {
        int balance = employee.getAnnualLeaves();
        for (LeaveRecord lr : leaveRecordList) {
            if (lr.employee.equals(employee)) {
                balance -= Day.daysBetween(lr.startDay, lr.endDay);
            }
        }
        return balance;
    }
}
