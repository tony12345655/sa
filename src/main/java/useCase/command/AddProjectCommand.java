package useCase.command;


import useCase.model.ProjectsModel;

public class AddProjectCommand implements Command{
    private final CommandDescription commandDescription;
    private final ProjectsModel projectsModel;
    public AddProjectCommand(CommandDescription commandDescription, ProjectsModel projectsModel){
        this.commandDescription = commandDescription;
        this.projectsModel = projectsModel;
    }
    @Override
    public String execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        this.projectsModel.addProject(commandRest[1]);
        return "";
    }

    @Override
    public String getCommandName() {
        return this.commandDescription.getCommandName();
    }
}
