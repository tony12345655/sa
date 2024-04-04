package useCase.command;

import entity.Project;
import entity.ProjectName;
import useCase.repository.ProjectsRepository;

public class AddTaskCommand extends Command{
    private final ProjectsRepository projectsRepository;
    public AddTaskCommand(CommandName name, ProjectsRepository projectsRepository){
        super(name);
        this.projectsRepository = projectsRepository;
    }
    @Override
    public String execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String[] commandRestSecond = commandRest[1].split(" ", 2);
        Project project = this.projectsRepository.getProject(ProjectName.of(commandRestSecond[0]));
        if (project == null) {
            return String.format("Could not find a project with the name \"%s\".", commandRestSecond[0]) + '\n';
        }
        this.projectsRepository.addTaskToProject(project.getName(), commandRestSecond[1]);
        return "";
    }
}
