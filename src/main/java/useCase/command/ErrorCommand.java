package useCase.command;

import useCase.port.input.CommandInput;
import useCase.port.output.CommandOutput;

public class ErrorCommand implements Command{
    @Override
    public CommandOutput execute(CommandInput commandInput) {
        return new CommandOutput(String.format("I don't know what the command \"%s\" is.", commandInput.commandLine) + '\n');
    }
}
