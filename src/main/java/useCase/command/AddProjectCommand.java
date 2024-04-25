package useCase.command;


import entity.ProjectName;
import entity.Projects;
import useCase.port.input.CommandInput;
import useCase.port.output.command.CommandOutput;
import adapter.output.presenter.repository.ProjectsInMemoryRepository;

public class AddProjectCommand implements Command{
    private final ProjectsInMemoryRepository projectsRepository;
    public AddProjectCommand(ProjectsInMemoryRepository projectsRepository){
        this.projectsRepository = projectsRepository;
    }
    @Override
    public CommandOutput execute(CommandInput commandInput) {
        Projects projects = this.projectsRepository.getProjects();
        projects.addProject(ProjectName.of(commandInput.commandLine));
        this.projectsRepository.save(projects);
        return new CommandOutput("success");
    }
}
