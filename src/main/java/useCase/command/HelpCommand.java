package useCase.command;

public class HelpCommand implements Command{
    private final CommandDescription commandDescription;

    public HelpCommand(CommandDescription commandDescription){
        this.commandDescription = commandDescription;
    }
    @Override
    public String execute(String commandLine){
        return "Commands:" + '\n' + "  show" + '\n' + "  add project <project name>" + '\n' + "  add task <project name> <task description>" + '\n' + "  check <task ID>" + '\n' + "  uncheck <task ID>" + '\n';
    }

    @Override
    public String getCommandName() {
        return this.commandDescription.getCommandName();
    }
}
