package adapter.controller.commandController;

import useCase.Projects;
import useCase.command.AddTaskCommand;
import useCase.command.Command;

public class AddTaskController implements CommandController{
    @Override
    public Command createCommand(String commandLine){
        String[] commandRest = commandLine.split(" ", 2);
        return new AddTaskCommand(commandRest[1]);
    }
}
