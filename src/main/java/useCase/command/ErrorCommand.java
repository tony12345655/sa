package useCase.command;

import entity.Project;
import java.util.LinkedHashMap;

public class ErrorCommand implements Command{
    private final String nowCommand;
    public ErrorCommand(String nowCommand){
        this.nowCommand = nowCommand;
    }
    @Override
    public String execute() {
        return String.format("I don't know what the command \"%s\" is.", this.nowCommand) + '\n';
    }
}
