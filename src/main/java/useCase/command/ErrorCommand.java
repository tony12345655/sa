package useCase.command;

public class ErrorCommand implements Command{
    private final CommandDescription commandDescription;

    public ErrorCommand(CommandDescription commandDescription){
        this.commandDescription = commandDescription;
    }
    @Override
    public String execute(String commandLine) {
        return String.format("I don't know what the command \"%s\" is.", commandLine) + '\n';
    }

    @Override
    public String getCommandName() {
        return this.commandDescription.getCommandName();
    }
}
