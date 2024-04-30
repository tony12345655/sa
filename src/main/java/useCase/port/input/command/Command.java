package useCase.port.input.command;


import useCase.port.input.command.CommandInput;
import useCase.port.output.command.CommandOutput;

public interface Command <T, Q>{
    Q execute(T t);
}
