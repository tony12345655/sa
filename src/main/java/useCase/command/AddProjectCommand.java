package useCase.command;


import entity.ProjectName;
import useCase.port.input.CommandInput;
import useCase.port.output.CommandOutput;
import useCase.repository.ProjectsRepository;

public class AddProjectCommand implements Command{
    private final ProjectsRepository projectsRepository;
    public AddProjectCommand(ProjectsRepository projectsRepository){
        this.projectsRepository = projectsRepository;
    }
    @Override
    public CommandOutput execute(CommandInput commandInput) {
        this.projectsRepository.addProject(ProjectName.of(commandInput.commandLine));
        return new CommandOutput("success");
    }
}
