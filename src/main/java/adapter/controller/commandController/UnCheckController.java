package adapter.controller.commandController;

import useCase.command.Command;
import useCase.command.UnCheckCommand;

public class UnCheckController implements CommandController{
    @Override
    public Command createCommand(String commandLine){
        String[] commandRest = commandLine.split(" ", 2);
        return new UnCheckCommand(commandRest[1]);
    }
}
