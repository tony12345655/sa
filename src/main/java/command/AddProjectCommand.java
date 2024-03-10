package command;

import application.ProjectApplication;
import project.Project;

import java.util.LinkedHashMap;

public class AddProjectCommand implements Command{
    @Override
    public String execute(LinkedHashMap<String, Project> projects, String nowCommand, String nextCommand) {
        Project project = ProjectApplication.getInstance().createProject(nextCommand);
        projects.put(nextCommand, project);
        return "";
    }
}
