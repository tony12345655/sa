package useCase.command;

import useCase.port.input.CommandInput;
import useCase.port.output.CommandOutput;
import useCase.repository.ProjectsRepository;

public class AddCommand implements Command{
    private final ProjectsRepository projectsRepository;
    public AddCommand(ProjectsRepository projectsRepository){
        this.projectsRepository = projectsRepository;
    }
    @Override
    public CommandOutput execute(CommandInput commandInput) {
        String[] commandRestSecond = commandInput.nextCommandLine.split(" ", 2);
        Command command = switch (commandRestSecond[0]) {
            case "project" -> new AddProjectCommand(this.projectsRepository);
            case "task" -> new AddTaskCommand(this.projectsRepository);
            default -> null;
        };

        if (command != null)
            return command.execute(new CommandInput(commandInput.nextCommandLine));
        else
            return new CommandOutput("");
    }
}
