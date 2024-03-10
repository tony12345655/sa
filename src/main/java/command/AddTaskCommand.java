package command;

import application.TaskApplication;
import project.Project;
import project.Task;

import java.util.LinkedHashMap;

public class AddTaskCommand implements Command{
    @Override
    public String execute(LinkedHashMap<String, Project> projects, String nowCommand, String nextCommand) {
        String[] commandRest = nextCommand.split(" ", 2);
        Project project = projects.get(commandRest[0]);
        if (project == null) {
            return String.format("Could not find a project with the name \"%s\".", commandRest[0]) + '\n';
        }
        Task task = TaskApplication.getInstance().createTask(commandRest[1]);
        project.AddTask(task);
        return "";
    }
}
