package useCase.command;

import useCase.repository.ProjectsRepository;

public class ShowCommand extends Command{
    private final ProjectsRepository projectsRepository;
    public ShowCommand(CommandName name, ProjectsRepository projectsRepository){
        super(name);
        this.projectsRepository = projectsRepository;
    }
    @Override
    public String execute(String commandLine) {
        return this.projectsRepository.getProjectsInfo();
    }

}
