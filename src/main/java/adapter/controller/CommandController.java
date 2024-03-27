package adapter.controller;

import useCase.command.*;
import useCase.model.ProjectsModel;

import java.util.ArrayList;
import java.util.List;

public class CommandController {
    private final List<Command> commands = new ArrayList<>();

    public CommandController(ProjectsModel projectsModel){
        commands.add(new AddCommand((new CommandDescription("add")), projectsModel));
        commands.add(new CheckCommand((new CommandDescription("check")), projectsModel));
        commands.add(new UnCheckCommand((new CommandDescription("uncheck")), projectsModel));
        commands.add(new HelpCommand((new CommandDescription("help"))));
        commands.add(new ShowCommand((new CommandDescription("show")), projectsModel));
    }

    public String  execute(String commandLine){
        String[] commandRest = commandLine.split(" ", 2);
        String commandName = commandRest[0];
        Command target_command = new ErrorCommand(new CommandDescription("error"));
        for (Command command : this.commands){
            if (commandName.equals(command.getCommandName()))
                target_command = command;
        }
        return target_command.execute(commandLine);
    }
}
