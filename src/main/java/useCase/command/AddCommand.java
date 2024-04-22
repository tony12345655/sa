package useCase.command;

import useCase.repository.ProjectsRepository;

public class AddCommand extends Command{
    private final ProjectsRepository projectsRepository;
    public AddCommand(CommandName name, ProjectsRepository projectsRepository){
        super(name);
        this.projectsRepository = projectsRepository;
    }
    @Override
    public String execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String[] commandRestSecond = commandRest[1].split(" ", 2);
        Command command = switch (commandRestSecond[0]) {
            case "project" -> new AddProjectCommand(CommandName.of("project"), this.projectsRepository);
            case "task" -> new AddTaskCommand(CommandName.of("task"), this.projectsRepository);
            default -> null;
        };

        if (command != null)
            return command.execute(commandRest[1]);
        else
            return "";
    }
}
