package command;

import project.Project;
import java.util.LinkedHashMap;

public class ErrorCommand implements Command{
    @Override
    public String execute(LinkedHashMap<String, Project> projects, String nowCommand, String nextCommand) {
        return String.format("I don't know what the command \"%s\" is.", nowCommand) + '\n';
    }
}
