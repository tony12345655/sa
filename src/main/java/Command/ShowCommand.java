package Command;

import CheckList.Project;

import java.util.LinkedHashMap;

public class ShowCommand implements   Command{
    private final LinkedHashMap<String, Project> projects;
    public ShowCommand(LinkedHashMap<String, Project> projects){
        this.projects = projects;
    }

    @Override
    public void execute() {
        for (String project_name : this.projects.keySet())
            this.projects.get(project_name).show();
    }
}
