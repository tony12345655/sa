package useCase.command;


import useCase.model.ProjectsModel;

public class AddProjectCommand implements Command{
    private final ProjectsModel projectsModel;
    public AddProjectCommand(ProjectsModel projectsModel){
        this.projectsModel = projectsModel;
    }
    @Override
    public String execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        this.projectsModel.addProject(commandRest[1]);
        return "";
    }
}
