package useCase.command;

import useCase.port.input.CommandInput;
import useCase.port.output.CommandOutput;
import useCase.repository.ProjectsRepository;

public class CheckCommand implements Command{
    private final ProjectsRepository projectsRepository;
    public CheckCommand(ProjectsRepository projectsRepository){
        this.projectsRepository = projectsRepository;
    }
    @Override
    public CommandOutput execute(CommandInput commandInput) {
        long taskId = Long.parseLong(commandInput.nextCommandLine);
        this.projectsRepository.setTaskDone(taskId, true);
        return new CommandOutput("");
    }
}
