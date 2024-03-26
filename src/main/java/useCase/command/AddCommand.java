package useCase.command;

import useCase.model.ProjectsModel;

public class AddCommand implements Command{
    private final ProjectsModel projectsModel;
    public AddCommand(ProjectsModel projectsModel){
        this.projectsModel = projectsModel;
    }
    @Override
    public String execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String[] commandRestSecond = commandRest[1].split(" ", 2);
        Command command = null;
        if (commandRestSecond[0].equals("project"))
            command = new AddProjectCommand(this.projectsModel);
        else if (commandRestSecond[0].equals("task"))
            command = new AddTaskCommand(this.projectsModel);

        if (command != null)
            return command.execute(commandRest[1]);
        else
            return "";
    }
}
