package command;

import checkList.CheckListFactory;
import checkList.Project;
import checkList.Task;
import com.codurance.training.tasks.TaskList;
import output.Out;

import java.util.LinkedHashMap;

public class AddTaskCommand implements Command{

    private final LinkedHashMap<String, Project> projects;

    public AddTaskCommand(LinkedHashMap<String, Project> projects){
        this.projects = projects;
    }

    @Override
    public void execute(String nextCommand) {
        String[] commandRest = nextCommand.split(" ", 2);
        Project project = this.projects.get(commandRest[0]);
        if (project == null) {
            Out.getInstance().printf("Could not find a project with the name \"%s\".", commandRest[0]);
            Out.getInstance().println();
            return;
        }
        Task task = CheckListFactory.getInstance().createTask(commandRest[1]);
        project.add(task);
    }
}
