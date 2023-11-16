public class CmdSuggestProjectTeam implements Command {
    @Override
    public void execute(String[] tokens) {
        /*
         * Usage: suggestProjectTeam <project name>
         */
        try {
            if (tokens.length < 2) {
                throw new ExInsufficientCommandArguments();
            }
            Company company = Company.getInstance();
            Project project = company.searchProject(tokens[1]);
            company.suggestProjectTeam(project);
        } catch (ExInsufficientCommandArguments e) {
            System.out.println(e.getMessage());
        } catch (ExProjectNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}
