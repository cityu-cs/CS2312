public class CmdTakeLeave extends RecordedCommand {
    private LeaveRecord leaveRecord;

    @Override
    public void execute(String[] tokens) {
        /*
         * Usage: takeLeave <employee name> <start date: day> <end date: day>
         */
        try {
            if (tokens.length < 4) {
                throw new ExInsufficientCommandArguments();
            }

            Company company = Company.getInstance();
            Employee employee = company.searchEmployee(tokens[1]);
            Day startDay = new Day(tokens[2]);
            Day endDay = new Day(tokens[3]);
            int interval = Day.daysBetween(startDay, endDay);
            company.checkOverlapLeaveRecords(employee, startDay, endDay); // may throw ExLeaveOverlapped
            company.checkProjectFinalStage(employee, startDay, endDay); // may throw ExLeaveInFinalStage

            int balance = company.getAnnualLeaveBalance(employee);
            if (balance < interval) {
                throw new ExInsufficientBalanceOfAnnualLeave(balance);
            }

            leaveRecord = new LeaveRecord(employee, startDay, endDay);
            company.addLeaveRecord(leaveRecord);

            RecordedCommand.addToUndoList(this);
            RecordedCommand.clearRedoList();
            System.out.printf("Done.  %s's remaining annual leave: %d days\n", 
                    employee.getName(), company.getAnnualLeaveBalance(employee));

        } catch (ExInsufficientCommandArguments e) {
            System.out.println(e.getMessage());
        } catch (ExEmployeeNotFound e) {
            System.out.println(e.getMessage());
        } catch (ExInsufficientBalanceOfAnnualLeave e) {
            System.out.println(e.getMessage());
        } catch (ExLeaveOverlapped e) {
            System.out.println(e.getMessage());
        } catch (ExLeaveInFinalStage e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void undoThis() {
        Company company = Company.getInstance();
        company.removeLeaveRecord(leaveRecord);
    }

    @Override
    public void redoThis() {
        Company company = Company.getInstance();
        company.addLeaveRecord(leaveRecord);
    }
}
