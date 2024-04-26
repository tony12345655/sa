package adapter.input.controller.console;

import useCase.command.Command;
import useCase.port.input.CommandInput;

public class CheckConsoleController implements ConsoleController{
    private final Command command;
    public CheckConsoleController(Command command){
        this.command = command;
    }

    @Override
    public void execute(String commandLine){
        String[] commandRest = commandLine.split(" ", 2);
        CommandInput commandInput = new CommandInput(commandRest[1]);
        this.command.execute(commandInput);
    }
}
