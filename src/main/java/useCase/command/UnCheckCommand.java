package useCase.command;

import useCase.model.ProjectsModel;

public class UnCheckCommand implements  Command{
    private final ProjectsModel projectsModel;

    public UnCheckCommand(ProjectsModel projectsModel){
        this.projectsModel = projectsModel;
    }
    @Override
    public String execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        long taskId = Long.parseLong(commandRest[1]);
        this.projectsModel.setTaskDone(taskId, false);
        return "";
    }
}
