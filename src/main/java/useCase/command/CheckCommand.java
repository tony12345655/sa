package useCase.command;

import useCase.repository.ProjectsRepository;

public class CheckCommand extends Command{
    private final ProjectsRepository projectsRepository;
    public CheckCommand(CommandName name, ProjectsRepository projectsRepository){
        super(name);
        this.projectsRepository = projectsRepository;
    }
    @Override
    public String execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        long taskId = Long.parseLong(commandRest[1]);
        this.projectsRepository.setTaskDone(taskId, true);
        return "";
    }
}
