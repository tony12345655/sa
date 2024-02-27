package Command;

import CheckList.CheckListFactory;
import CheckList.Project;
import CheckList.Task;

import java.util.LinkedHashMap;

public class AddTaskCommand implements Command{

    private final String project_name;
    private final Project project;
    private final String description;
    public AddTaskCommand(LinkedHashMap<String, Project> projects, String project_name, String description){
        this.project_name = project_name;
        this.project = projects.get(project_name);
        this.description = description;
    }

    @Override
    public void execute() {
        if (this.project == null) {
            System.out.printf("Could not find a project with the name \"%s\".", this.project_name);
            System.out.println();
            return;
        }
        Task task = CheckListFactory.getInstance().createTask(description);
        this.project.add(task);
    }
}
