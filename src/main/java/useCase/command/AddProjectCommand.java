package useCase.command;

import useCase.Projects;

public class AddProjectCommand implements Command{
    private final String nextCommand;
    public AddProjectCommand(String nextCommand){
        this.nextCommand = nextCommand;
    }
    @Override
    public String execute() {
        Projects.getInstance().createProject(this.nextCommand);
        return "";
    }
}
