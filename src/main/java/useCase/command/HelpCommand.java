package useCase.command;

public class HelpCommand implements Command{
    @Override
    public String execute(String commandLine){
        return "Commands:" + '\n' + "  show" + '\n' + "  add project <project name>" + '\n' + "  add task <project name> <task description>" + '\n' + "  check <task ID>" + '\n' + "  uncheck <task ID>" + '\n';
    }
}
