package useCase.command;

import useCase.port.input.CommandInput;
import useCase.port.output.CommandOutput;
import useCase.repository.ProjectsRepository;

public class UnCheckCommand implements Command{
    private final ProjectsRepository projectsRepository;

    public UnCheckCommand(ProjectsRepository projectsRepository){
        this.projectsRepository = projectsRepository;
    }
    @Override
    public CommandOutput execute(CommandInput commandInput) {
        long taskId = Long.parseLong(commandInput.nextCommandLine);
        this.projectsRepository.setTaskDone(taskId, false);
        return new CommandOutput("");
    }
}
