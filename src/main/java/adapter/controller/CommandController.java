package adapter.controller;

import useCase.command.*;
import useCase.model.ProjectsModel;

import java.util.LinkedHashMap;
import java.util.Map;

public class CommandController {
    private final Map<String, Command> commandMap = new LinkedHashMap<>();

    public CommandController(ProjectsModel projectsModel){
        commandMap.put("add", new AddCommand(projectsModel));
        commandMap.put("check", new CheckCommand(projectsModel));
        commandMap.put("uncheck", new UnCheckCommand(projectsModel));
        commandMap.put("help", new HelpCommand());
        commandMap.put("show", new ShowCommand(projectsModel));
        commandMap.put("error", new ErrorCommand());
    }

    public String  execute(String commandLine){
        String[] commandRest = commandLine.split(" ", 2);
        Command command = this.commandMap.getOrDefault(commandRest[0], commandMap.get("error"));
        return command.execute(commandLine);
    }
}
