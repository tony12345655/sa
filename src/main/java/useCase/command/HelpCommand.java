package useCase.command;

public class HelpCommand extends Command{
    public HelpCommand(CommandName name){
        super(name);
    }
    @Override
    public String execute(String commandLine){
        return "Commands:" + '\n' + "  show" + '\n' + "  add project <project name>" + '\n' + "  add task <project name> <task description>" + '\n' + "  check <task ID>" + '\n' + "  uncheck <task ID>" + '\n';
    }
}
