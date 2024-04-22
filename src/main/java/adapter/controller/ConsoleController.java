package adapter.controller;

import useCase.command.*;

import java.util.ArrayList;
import java.util.List;

public class ConsoleController {
    private final List<Command> commands = new ArrayList<>();
    private final Command errorCommand;

    public ConsoleController(Command addCommand, Command checkCommand, Command unCheckCommand, Command helpCommand, Command showCommand, Command errorCommand){
            this.commands.add(addCommand);
            this.commands.add(checkCommand);
            this.commands.add(unCheckCommand);
            this.commands.add(helpCommand);
            this.commands.add(showCommand);
            this.errorCommand = errorCommand;
    }

    public String  execute(String commandLine){
        String[] commandRest = commandLine.split(" ", 2);
        CommandName name = CommandName.of(commandRest[0]);
        Command target_command = this.errorCommand;
        for (Command command : this.commands){
            if (name.equals(command.getCommandName()))
                target_command = command;
        }
        return target_command.execute(commandLine);
    }
}
