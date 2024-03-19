package adapter.controller.commandController;

import useCase.Projects;
import useCase.command.Command;
import useCase.command.ShowCommand;

public class ShowController implements CommandController{
    @Override
    public Command createCommand(String commandLine) {
        return new ShowCommand();
    }
}
