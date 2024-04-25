package useCase.command;

import useCase.port.input.CommandInput;
import useCase.port.output.command.CommandOutput;
import adapter.output.presenter.repository.ProjectsInMemoryRepository;

public class AddCommand implements Command{
    private final ProjectsInMemoryRepository projectsRepository;
    public AddCommand(ProjectsInMemoryRepository projectsRepository){
        this.projectsRepository = projectsRepository;
    }
    @Override
    public CommandOutput execute(CommandInput commandInput) {
        String[] commandRest = commandInput.commandLine.split(" ", 2);
        Command command = switch (commandRest[0]) {
            case "project" -> new AddProjectCommand(this.projectsRepository);
            case "task" -> new AddTaskCommand(this.projectsRepository);
            default -> null;
        };

        if (command != null)
            return command.execute(new CommandInput(commandRest[1]));
        else
            return new CommandOutput("not found");
    }
}
