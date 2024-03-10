package command;
import project.Project;
import java.util.LinkedHashMap;

public interface Command {
    String execute(LinkedHashMap<String, Project> projects, String nowCommand, String nextCommand);
}
