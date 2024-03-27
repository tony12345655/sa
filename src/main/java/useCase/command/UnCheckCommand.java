package useCase.command;

import useCase.model.ProjectsModel;

public class UnCheckCommand implements  Command{
    private final CommandDescription commandDescription;
    private final ProjectsModel projectsModel;

    public UnCheckCommand(CommandDescription commandDescription, ProjectsModel projectsModel){
        this.commandDescription = commandDescription;
        this.projectsModel = projectsModel;
    }
    @Override
    public String execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        long taskId = Long.parseLong(commandRest[1]);
        this.projectsModel.setTaskDone(taskId, false);
        return "";
    }

    @Override
    public String getCommandName() {
        return this.commandDescription.getCommandName();
    }
}
