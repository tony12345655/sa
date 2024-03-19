package useCase.command;

import entity.Project;
import useCase.Projects;
import entity.Task;

import java.util.Map;

public class ShowCommand implements Command{
    @Override
    public String execute() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Project> project : Projects.getInstance().entrySet()){
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
