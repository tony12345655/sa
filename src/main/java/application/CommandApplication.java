package application;

import command.*;

import java.util.LinkedHashMap;

public class CommandApplication {
    private static CommandApplication instance;

    private static final LinkedHashMap<String, Command> commands = new LinkedHashMap<>();

    public static CommandApplication getInstance(){
        if (instance == null){
            commands.put("help", new HelpCommand());
            commands.put("error", new ErrorCommand());
            commands.put("show", new ShowCommand());
            commands.put("add", new AddCommand());
            commands.put("project", new AddProjectCommand());
            commands.put("task", new AddTaskCommand());
            commands.put("check", new CheckCommand());
            commands.put("uncheck", new UnCheckCommand());
            instance = new CommandApplication();
        }

        return  instance;
    }

    public Command CreateCommand(String name){
        return commands.get(name);
    }
}
