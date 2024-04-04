package useCase.command;


import useCase.repository.ProjectsRepository;

public class AddProjectCommand extends Command{
    private final ProjectsRepository projectsRepository;
    public AddProjectCommand(CommandName name, ProjectsRepository projectsRepository){
        super(name);
        this.projectsRepository = projectsRepository;
    }
    @Override
    public String execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        this.projectsRepository.addProject(commandRest[1]);
        return "";
    }
}
