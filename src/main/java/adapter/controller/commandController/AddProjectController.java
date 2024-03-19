package adapter.controller.commandController;

import useCase.command.AddProjectCommand;
import useCase.command.Command;

public class AddProjectController implements CommandController{
    @Override
    public Command createCommand(String commandLine){
        String[] commandRest = commandLine.split(" ", 2);
        return new AddProjectCommand(commandRest[1]);
    }
}
