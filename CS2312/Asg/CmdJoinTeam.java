public class CmdJoinTeam extends RecordedCommand {
    EmployeeTeamRelation etr;
    
    @Override
    public void execute(String[] tokens) {
        /*
         * Usage: joinTeam <employee name> <team name>
         */
        try {
            if (tokens.length < 3)
                throw new ExInsufficientCommandArguments();
            
            Company company = Company.getInstance();
            Employee employee = company.searchEmployee(tokens[1]);

            try {
                Team anotherTeam = company.searchTeamByEmployee(employee);
                throw new ExEmployeeHasJoinedAnotherTeam(employee.getName(), anotherTeam.getTeamName());
            } catch (ExTeamNotFound e) {
                // do nothing
            }

            Team team = company.searchTeam(tokens[2]);
            etr = new EmployeeTeamRelation(employee, team, new RMember());
            company.addEmployeeTeamRelation(etr);

            RecordedCommand.addToUndoList(this);
            RecordedCommand.clearRedoList();
            System.out.println("Done.");
        } catch (ExInsufficientCommandArguments e) {
            System.out.println(e.getMessage());
        } catch (ExEmployeeNotFound e) {
            System.out.println(e.getMessage());
        } catch (ExEmployeeHasJoinedAnotherTeam e) {
            System.out.println(e.getMessage());
        } catch (ExTeamNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void undoThis() {
        Company company = Company.getInstance();
        company.removeEmployeeTeamRelation(etr);
    }

    @Override
    public void redoThis() {
        Company company = Company.getInstance();
        company.addEmployeeTeamRelation(etr);
    }
}
