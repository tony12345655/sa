package useCase.service;


import entity.ProjectName;
import entity.Projects;
import useCase.port.input.command.CommandInput;
import useCase.port.input.command.CommandUseCase;
import useCase.port.output.command.CommandOutput;
import adapter.output.repository.ProjectsInMemoryRepository;

public class AddProjectService implements CommandUseCase {
    private final ProjectsInMemoryRepository projectsRepository;
    public AddProjectService(ProjectsInMemoryRepository projectsRepository){
        this.projectsRepository = projectsRepository;
    }
    @Override
    public CommandOutput execute(CommandInput commandInput) {
        Projects projects = this.projectsRepository.getProjects();
        projects.addProject(ProjectName.of(commandInput.commandLine));
        this.projectsRepository.save(projects);
        return new CommandOutput(null);
    }
}
