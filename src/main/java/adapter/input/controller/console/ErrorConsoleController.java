package adapter.input.controller.console;

import adapter.output.presenter.console.ConsoleCommandPresenter;
import useCase.port.input.command.Command;
import useCase.port.input.command.CommandInput;
import useCase.port.input.command.CommandUseCase;
import useCase.port.output.command.CommandOutput;

public class ErrorConsoleController implements ConsoleController{
    private final CommandUseCase commandService;
    private final ConsoleCommandPresenter presenter;

    public ErrorConsoleController(CommandUseCase commandService, ConsoleCommandPresenter consoleCommandPresenter){
        this.commandService = commandService;
        this.presenter = consoleCommandPresenter;
    }

    public void execute(String commandLine){
        CommandInput commandInput = new CommandInput(commandLine);
        CommandOutput commandOutput = this.commandService.execute(commandInput);
        this.presenter.present(commandOutput.message);
    }
}
