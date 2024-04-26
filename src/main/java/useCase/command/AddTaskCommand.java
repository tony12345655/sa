package useCase.command;

import entity.Project;
import entity.ProjectName;
import entity.Projects;
import useCase.port.input.CommandInput;
import useCase.port.output.command.CommandOutput;
import adapter.output.presenter.repository.ProjectsInMemoryRepository;

public class AddTaskCommand implements Command{
    private final ProjectsInMemoryRepository projectsRepository;
    public AddTaskCommand(ProjectsInMemoryRepository projectsRepository){
        this.projectsRepository = projectsRepository;
    }
    @Override
    public CommandOutput execute(CommandInput commandInput) {
        String[] commandRestSecond = commandInput.commandLine.split(" ", 2);
        Projects projects = this.projectsRepository.getProjects();
        Project project = projects.getProject(ProjectName.of(commandRestSecond[0]));
        if (project == null) {
            return new CommandOutput(String.format("Could not find a project with the name \"%s\".", commandRestSecond[0]) + '\n');
        }
        projects.addTaskToProject(project.getName(), commandRestSecond[1], false);
        this.projectsRepository.save(projects);
        return new CommandOutput(null);
    }
}
