package adapter.controller.commandController;

import useCase.command.Command;

public class AddController implements CommandController{
    public Command createCommand(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String[] commandRestSecond = commandRest[1].split(" ", 2);
        CommandController controller = CommandControllers.getInstance().getCommandController(commandRestSecond[0]);
        return controller.createCommand(commandRest[1]);
    }
}
