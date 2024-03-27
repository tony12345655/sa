package useCase.command;


public interface Command {
    String execute(String commandLine);

    String getCommandName();

}
