package adapter.controller.commandController;

import useCase.command.AddTaskCommand;

import java.util.LinkedHashMap;

public class CommandControllers {

    private CommandControllers(){};
    private final static LinkedHashMap<String, CommandController> commandControllers = new LinkedHashMap<>();
    public static CommandControllers instance;

    public static CommandControllers getInstance() {
        if (instance == null){
            commandControllers.put("add", new AddController());
            commandControllers.put("project", new AddProjectController());
            commandControllers.put("task", new AddTaskController());
            commandControllers.put("check", new CheckController());
            commandControllers.put("uncheck", new UnCheckController());
            commandControllers.put("help", new HelpCommandController());
            commandControllers.put("show", new ShowController());
            instance = new CommandControllers();
        }
        return instance;
    }

    public CommandController getCommandController(String name){
        CommandController controller = commandControllers.get(name);
        if (controller == null){
            System.out.println(name);
            controller = new ErrorController();
        }


        return controller;
    }
}
