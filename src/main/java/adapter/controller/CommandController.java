package adapter.controller;

import useCase.command.Command;
import useCase.port.input.CommandInput;
import useCase.port.output.CommandOutput;

public class CommandController {
    private final Command command;

    public CommandController(Command command){
        this.command = command;
    }

    public String execute(String CommandLine){
        CommandInput commandInput = new CommandInput(CommandLine);
        CommandOutput commandOutput = this.command.execute(commandInput);
        return commandOutput.message;
    }
}
