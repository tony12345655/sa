package Command;

import CheckList.CheckListFactory;
import CheckList.Project;

import java.util.LinkedHashMap;

public class AddProjectCommand implements Command{
    private final LinkedHashMap<String, Project> projects;
    private final String name;

    public AddProjectCommand(LinkedHashMap<String, Project> projects, String name){
        this.projects = projects;
        this.name = name;
    };

    @Override
    public void execute() {
        Project project = CheckListFactory.getInstance().createProject(this.name);
        this.projects.put(this.name, project);
    }
}
