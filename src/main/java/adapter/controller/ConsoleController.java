package adapter.controller;

import useCase.command.*;
import useCase.port.input.CommandInput;
import useCase.port.output.CommandOutput;

public class ConsoleController {

    private final Command addCommand;
    private final Command checkCommand;
    private final Command unCheckCommand;
    private final Command helpCommand;
    private final Command showCommand;
    private final Command errorCommand;

    public ConsoleController(Command addCommand, Command checkCommand, Command unCheckCommand, Command helpCommand, Command showCommand, Command errorCommand){
            this.addCommand = addCommand;
            this.checkCommand = checkCommand;
            this.unCheckCommand = unCheckCommand;
            this.helpCommand = helpCommand;
            this.showCommand = showCommand;
            this.errorCommand = errorCommand;
    }

    public CommandOutput execute(String commandLine){
        CommandInput commandInput = new CommandInput(commandLine);
        Command command = switch (commandInput.nowCommandLine) {
            case "add" -> this.addCommand;
            case "check" -> this.checkCommand;
            case "uncheck" -> this.unCheckCommand;
            case "help" -> this.helpCommand;
            case "show" -> this.showCommand;
            default -> this.errorCommand;
        };
        return command.execute(commandInput);
    }
}
