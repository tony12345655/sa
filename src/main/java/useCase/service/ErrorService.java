package useCase.service;

import useCase.port.input.command.Command;
import useCase.port.input.command.CommandInput;
import useCase.port.input.command.CommandUseCase;
import useCase.port.output.command.CommandOutput;

public class ErrorService implements CommandUseCase {
    @Override
    public CommandOutput execute(CommandInput commandInput) {
        return new CommandOutput(String.format("I don't know what the command \"%s\" is.", commandInput.commandLine) + '\n');
    }
}
