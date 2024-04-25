package adapter.input.controller.console;

import useCase.command.Command;
import useCase.port.input.CommandInput;
import useCase.port.output.command.CommandOutput;

public class ConsoleCommandController {
    private final Command command;

    public ConsoleCommandController(Command command){
        this.command = command;
    }

    public String execute(String CommandLine){
        CommandInput commandInput = new CommandInput(CommandLine);
        CommandOutput commandOutput = this.command.execute(commandInput);
        return commandOutput.message;
    }
}
