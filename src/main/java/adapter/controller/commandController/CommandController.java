package adapter.controller.commandController;

import useCase.command.Command;

public interface CommandController {
    public Command createCommand(String CommandLine);
}
