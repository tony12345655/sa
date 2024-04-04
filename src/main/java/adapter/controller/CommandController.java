package adapter.controller;

import useCase.command.*;
import useCase.repository.ProjectsRepository;

import java.util.ArrayList;
import java.util.List;

public class CommandController {
    private final List<Command> commands = new ArrayList<>();

    public CommandController(ProjectsRepository projectsRepository){
        commands.add(new AddCommand((CommandName.of("add")), projectsRepository));
        commands.add(new CheckCommand((CommandName.of("check")), projectsRepository));
        commands.add(new UnCheckCommand((CommandName.of("uncheck")), projectsRepository));
        commands.add(new HelpCommand((CommandName.of("help"))));
        commands.add(new ShowCommand((CommandName.of("show")), projectsRepository));
    }

    public String  execute(String commandLine){
        String[] commandRest = commandLine.split(" ", 2);
        CommandName name = CommandName.of(commandRest[0]);
        Command target_command = new ErrorCommand(CommandName.of("error"));
        for (Command command : this.commands){
            if (name.equals(command.getCommandName()))
                target_command = command;
        }
        return target_command.execute(commandLine);
    }
}
