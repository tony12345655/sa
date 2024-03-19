package adapter.controller.commandController;

import useCase.command.Command;
import useCase.command.ErrorCommand;

public class ErrorController implements CommandController{
    @Override
    public Command createCommand(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        return new ErrorCommand(commandRest[0]);
    }
}
