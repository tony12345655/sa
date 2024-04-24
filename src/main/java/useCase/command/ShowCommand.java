package useCase.command;

import useCase.port.input.CommandInput;
import useCase.port.output.CommandOutput;
import useCase.repository.ProjectsRepository;

public class ShowCommand implements Command{
    private final ProjectsRepository projectsRepository;
    public ShowCommand(ProjectsRepository projectsRepository){
        this.projectsRepository = projectsRepository;
    }
    @Override
    public CommandOutput execute(CommandInput commandInput) {
        return new CommandOutput(this.projectsRepository.getProjectsInfo());
    }

}
