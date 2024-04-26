package adapter.input.controller.console;

import adapter.output.presenter.console.ConsoleCommandPresenter;
import useCase.command.Command;
import useCase.port.input.CommandInput;
import useCase.port.output.command.CommandOutput;

public class ErrorConsoleController implements ConsoleController{
    private final Command command;
    private final ConsoleCommandPresenter presenter;

    public ErrorConsoleController(Command command, ConsoleCommandPresenter consoleCommandPresenter){
        this.command = command;
        this.presenter = consoleCommandPresenter;
    }

    public void execute(String commandLine){
        CommandInput commandInput = new CommandInput(commandLine);
        CommandOutput commandOutput = this.command.execute(commandInput);
        this.presenter.present(commandOutput.message);
    }
}
