package useCase.command;

import entity.Project;
import useCase.Projects;
import entity.Task;

import java.util.Map;

public class ShowCommand implements Command{
    @Override
    public String execute() {
        return Projects.getInstance().showProjects();
    }
}
