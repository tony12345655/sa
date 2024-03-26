package useCase.command;

import useCase.model.ProjectsModel;

public class ShowCommand implements Command{
    private final ProjectsModel projectsModel;
    public ShowCommand(ProjectsModel projectsModel){
        this.projectsModel = projectsModel;
    }
    @Override
    public String execute(String commandLine) {
        return this.projectsModel.getProjectsInfo();
    }
}
