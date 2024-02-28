package Command;

import CheckList.CheckListFactory;
import CheckList.Project;

import java.util.LinkedHashMap;

public class AddProjectCommand implements Command{
    private final LinkedHashMap<String, Project> projects;

    public AddProjectCommand(LinkedHashMap<String, Project> projects){
        this.projects = projects;
    }

    @Override
    public void execute(String nextCommand) {
        Project project = CheckListFactory.getInstance().createProject(nextCommand);
        this.projects.put(nextCommand, project);
    }
}
