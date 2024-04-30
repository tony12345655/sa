package useCase.service;

import entity.Projects;
import useCase.port.input.command.CommandInput;
import useCase.port.input.command.CommandUseCase;
import useCase.port.output.command.CommandOutput;
import adapter.output.repository.ProjectsInMemoryRepository;

public class CheckService implements CommandUseCase {
    private final ProjectsInMemoryRepository projectsRepository;
    public CheckService(ProjectsInMemoryRepository projectsRepository){
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
