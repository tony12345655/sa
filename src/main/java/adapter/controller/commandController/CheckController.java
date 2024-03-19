package adapter.controller.commandController;

import entity.Task;
import useCase.command.CheckCommand;
import useCase.command.Command;

public class CheckController implements CommandController{
    @Override
    public Command createCommand(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        return new CheckCommand(commandRest[1]);
    }
}
