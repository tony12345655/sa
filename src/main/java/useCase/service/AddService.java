package useCase.service;

import useCase.port.input.command.CommandInput;
import useCase.port.input.command.CommandUseCase;
import useCase.port.output.command.CommandOutput;
import adapter.output.repository.ProjectsInMemoryRepository;

public class AddService implements CommandUseCase {
    private final ProjectsInMemoryRepository projectsRepository;
    public AddService(ProjectsInMemoryRepository projectsRepository){
        this.projectsRepository = projectsRepository;
    }
    @Override
    public CommandOutput execute(CommandInput commandInput) {
        String[] commandRest = commandInput.commandLine.split(" ", 2);
        CommandUseCase command = switch (commandRest[0]) {
            case "project" -> new AddProjectService(this.projectsRepository);
            case "task" -> new AddTaskService(this.projectsRepository);
            default -> null;
        };

        if (command != null)
            return command.execute(new CommandInput(commandRest[1]));
        else
            return new CommandOutput("not found");
    }
}
