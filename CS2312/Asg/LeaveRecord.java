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

    public Day getStartDay() {
        return startDay;
    }

    public Day getEndDay() {
        return endDay;
    }

    @Override
    public String toString() {
        return String.format("%s to %s", startDay, endDay);
    }

    @Override
    public int compareTo(LeaveRecord rhs) {
        if (this.employee.equals(rhs.employee)) {
            return this.startDay.compareTo(rhs.startDay);
        } else {
            return this.employee.compareTo(rhs.employee);
        }
    }

    /* Static methods */

    public static ArrayList<LeaveRecord> searchLeaveRecords(ArrayList<LeaveRecord> leaveRecordList, Employee employee) {
        Day systemDate = SystemDate.getInstance();
        ArrayList<LeaveRecord> result = new ArrayList<>();
        for (LeaveRecord lr : leaveRecordList) {
            if (lr.employee.equals(employee) && lr.endDay.compareTo(systemDate) >= 0) {
                result.add(lr);
            }
        }
        return result;
    }

    public static void listLeaveRecordsByEmployee(ArrayList<LeaveRecord> leaveRecordList, Employee employee) {
        System.out.printf("%s: ", employee.getName());
        ArrayList<LeaveRecord> result = searchLeaveRecords(leaveRecordList, employee);
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
            listLeaveRecordsByEmployee(leaveRecordList, e);
        }
    }

    public static void checkOverlapLeaveRecords(ArrayList<LeaveRecord> leaveRecordList, Employee e, Day startDay, Day endDay)
            throws ExLeaveOverlapped {
        for (LeaveRecord lr : leaveRecordList) {
            if (lr.employee.equals(e) && Day.checkOverlap(startDay, endDay, lr.startDay, lr.endDay)) {
                throw new ExLeaveOverlapped();
            }
        }
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

    public static double getManpowerDuringPeriod(ArrayList<LeaveRecord> leaveRecordList,
            ArrayList<Employee> teamMembers, Day projectStartDay, Day projectEndDay) {
        double manpower = 0;
        int totalDays = Day.daysBetween(projectStartDay, projectEndDay);
        for (Employee e : teamMembers) {
            manpower += 1.0;
            ArrayList<LeaveRecord> result = searchLeaveRecords(leaveRecordList, e);
            for (LeaveRecord lr : result) {
                Day leaveStartDay = lr.startDay;
                Day leaveEndDay = lr.endDay;
                int overlapDays = Day.getOverlapDays(leaveStartDay, leaveEndDay, projectStartDay, projectEndDay);
                manpower -= 1.0 * overlapDays / totalDays;
            }
        }
        return manpower;
    }
}
