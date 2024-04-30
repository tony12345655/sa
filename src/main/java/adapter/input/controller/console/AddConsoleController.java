package adapter.input.controller.console;

import useCase.port.input.command.Command;
import useCase.port.input.command.CommandInput;
import useCase.port.input.command.CommandUseCase;

public class AddConsoleController implements ConsoleController{
    private final CommandUseCase commandService;
    public AddConsoleController(CommandUseCase commandService){
        this.commandService = commandService;
    }

    @Override
    public void execute(String commandLine){
        String[] commandRest = commandLine.split(" ", 2);
        CommandInput commandInput = new CommandInput(commandRest[1]);
        this.commandService.execute(commandInput);
    }
}
