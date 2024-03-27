package useCase.command;

import entity.Project;
import useCase.model.ProjectsModel;

public class AddTaskCommand implements Command{
    private final CommandDescription commandDescription;
    private final ProjectsModel projectsModel;
    public AddTaskCommand(CommandDescription commandDescription, ProjectsModel projectsModel){
        this.commandDescription = commandDescription;
        this.projectsModel = projectsModel;
    }
    @Override
    public String execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String[] commandRestSecond = commandRest[1].split(" ", 2);
        Project project = this.projectsModel.getProject(commandRestSecond[0]);
        if (project == null) {
            return String.format("Could not find a project with the name \"%s\".", commandRestSecond[0]) + '\n';
        }
        this.projectsModel.addTaskToProject(project.getName(), commandRestSecond[1]);
        return "";
    }

    @Override
    public String getCommandName() {
        return this.commandDescription.getCommandName();
    }
}
