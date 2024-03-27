package useCase.command;

import useCase.model.ProjectsModel;

public class ShowCommand implements Command{
    private final CommandDescription commandDescription;
    private final ProjectsModel projectsModel;
    public ShowCommand(CommandDescription commandDescription, ProjectsModel projectsModel){
        this.commandDescription = commandDescription;
        this.projectsModel = projectsModel;
    }
    @Override
    public String execute(String commandLine) {
        return this.projectsModel.getProjectsInfo();
    }

    @Override
    public String getCommandName() {
        return this.commandDescription.getCommandName();
    }
}
