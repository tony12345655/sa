package useCase.command;


import useCase.port.input.CommandInput;
import useCase.port.output.CommandOutput;

public interface Command {
    CommandOutput execute(CommandInput commandInput);
}
