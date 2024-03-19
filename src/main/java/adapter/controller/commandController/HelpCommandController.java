package adapter.controller.commandController;

import useCase.command.Command;
import useCase.command.HelpCommand;

public class HelpCommandController implements CommandController{
    @Override
    public Command createCommand(String CommandLine) {
        return new HelpCommand();
    }
}
