package useCase.command;

import entity.Project;
import useCase.Projects;
import entity.Task;
import useCase.Tasks;

public class AddTaskCommand implements Command{
    private final Projects projects;
    private final String nextCommand;
    public AddTaskCommand(String nextCommand){
        this.projects = Projects.getInstance();
        this.nextCommand = nextCommand;
    }
    @Override
    public String execute() {
        String[] commandRest = this.nextCommand.split(" ", 2);
        Project project = projects.getProject(commandRest[0]);
        if (project == null) {
            return String.format("Could not find a project with the name \"%s\".", commandRest[0]) + '\n';
        }
        Task task = Tasks.getInstance().createTask(commandRest[1]);
        project.AddTask(task);
        return "";
    }
}
