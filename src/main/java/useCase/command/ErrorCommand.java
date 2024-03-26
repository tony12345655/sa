package useCase.command;

public class ErrorCommand implements Command{
    @Override
    public String execute(String commandLine) {
        return String.format("I don't know what the command \"%s\" is.", commandLine) + '\n';
    }
}
