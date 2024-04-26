package adapter.input.controller.console;

import adapter.output.presenter.console.ConsoleCommandPresenter;
import useCase.command.Command;
import useCase.port.input.CommandInput;
import useCase.port.output.command.CommandOutput;

public class AddConsoleController implements ConsoleController{
    private final Command command;
    public AddConsoleController(Command command){
        this.command = command;
    }

    @Override
    public void execute(String commandLine){
        String[] commandRest = commandLine.split(" ", 2);
        CommandInput commandInput = new CommandInput(commandRest[1]);
        this.command.execute(commandInput);
    }
}
