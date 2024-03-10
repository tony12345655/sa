package command;

import project.Project;
import project.Task;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShowCommand implements Command{
    @Override
    public String execute(LinkedHashMap<String, Project> projects, String nowCommand, String nextCommand) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Project> project : projects.entrySet()){
            result.append(project.getKey()).append("\r\n");
            for (Task task : project.getValue().getTasks()){
                String str = String.format("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
                result.append(str);
            }
            result.append("\r\n");
        }
        return result.toString();
    }
}
