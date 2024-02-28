package Command;

import CheckList.Project;

import java.util.LinkedHashMap;

public class ErrorCommand implements Command{

    private final String unKnowCommand;
    public ErrorCommand(String unKnowCommand){
        this.unKnowCommand = unKnowCommand;
    }
    @Override
    public void execute(String nextCommand) {
        System.out.printf("I don't know what the command \"%s\" is.", this.unKnowCommand);
        System.out.println();
    }
}
