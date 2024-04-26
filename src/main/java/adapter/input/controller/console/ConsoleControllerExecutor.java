package adapter.input.controller.console;

import java.util.HashMap;
import java.util.Map;

public class ConsoleControllerExecutor {

    private final Map<String, ConsoleController> consoleControllerMap;

    public ConsoleControllerExecutor(){
        this.consoleControllerMap = new HashMap<>();
    }

    public void register(String command, ConsoleController controller){
        this.consoleControllerMap.put(command, controller);
    }


    public void execute(String commandLine){
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        ConsoleController controller;
        if (this.consoleControllerMap.containsKey(command))
            controller = this.consoleControllerMap.get(command);
        else
            controller = this.consoleControllerMap.get(ProjectsCommands.ERROR);
        controller.execute(commandLine);
    }
}
