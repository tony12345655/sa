package useCase.service;

import entity.Projects;
import useCase.port.input.command.CommandInput;
import useCase.port.input.command.CommandUseCase;
import useCase.port.output.command.CommandOutput;
import adapter.output.repository.ProjectsInMemoryRepository;

public class UnCheckService implements CommandUseCase {
    private final ProjectsInMemoryRepository projectsRepository;

    public UnCheckService(ProjectsInMemoryRepository projectsRepository){
        this.projectsRepository = projectsRepository;
    }
    @Override
    public CommandOutput execute(CommandInput commandInput) {
        long taskId = Long.parseLong(commandInput.commandLine);
        Projects projects = this.projectsRepository.getProjects();
        projects.setTaskDone(taskId, false);
        this.projectsRepository.save(projects);
        return new CommandOutput("");
    }
}
