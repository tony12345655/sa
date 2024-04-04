package useCase.command;

public class ErrorCommand extends Command{
    public ErrorCommand(CommandName name){
        super(name);
    }
    @Override
    public String execute(String commandLine) {
        return String.format("I don't know what the command \"%s\" is.", commandLine) + '\n';
    }
}
