package Command;

import CheckList.Project;

import java.util.LinkedHashMap;

public class AddCommand implements Command{
    private final LinkedHashMap<String, Project> projects;
    private final String[] subcommandRest;
    public AddCommand(LinkedHashMap<String, Project> projects, String commandLine){
        this.projects = projects;
        this.subcommandRest = commandLine.split(" ", 2);
    }

    @Override
    public void execute() {
        if (this.subcommandRest[0].equals("project")){
            Command command = new AddProjectCommand(this.projects, this.subcommandRest[1]);
            command.execute();
        }
        else if (this.subcommandRest[0].equals("task")){
            String[] projectTask = subcommandRest[1].split(" ", 2);
            Command command = new AddTaskCommand(this.projects, projectTask[0], projectTask[1]);
            command.execute();
        }
    }
}
