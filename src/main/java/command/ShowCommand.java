package command;

import checkList.Project;

import java.util.LinkedHashMap;

public class ShowCommand implements   Command{
    private final LinkedHashMap<String, Project> projects;
    public ShowCommand(LinkedHashMap<String, Project> projects){
        this.projects = projects;
    }

    @Override
    public void execute(String nextCommand) {
        for (String project_name : this.projects.keySet())
            this.projects.get(project_name).show();
    }
}
