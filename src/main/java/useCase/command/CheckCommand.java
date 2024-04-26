package useCase.command;

import entity.Projects;
import useCase.port.input.CommandInput;
import useCase.port.output.command.CommandOutput;
import adapter.output.presenter.repository.ProjectsInMemoryRepository;

public class CheckCommand implements Command{
    private final ProjectsInMemoryRepository projectsRepository;
    public CheckCommand(ProjectsInMemoryRepository projectsRepository){
        this.projectsRepository = projectsRepository;
    }
    @Override
    public CommandOutput execute(CommandInput commandInput) {
        long taskId = Long.parseLong(commandInput.commandLine);
        Projects projects = this.projectsRepository.getProjects();
        projects.setTaskDone(taskId, true);
        this.projectsRepository.save(projects);
        return new CommandOutput(null);
    }
}
