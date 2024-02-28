package command;

import checkList.Project;

import java.util.LinkedHashMap;

public class AddCommand implements Command{
    private final LinkedHashMap<String, Project> projects;
    public AddCommand(LinkedHashMap<String, Project> projects){
        this.projects = projects;
    }

    @Override
    public void execute(String nextCommand) {
        String[] subcommandRest = nextCommand.split(" ", 2);
        if (subcommandRest[0].equals("project")){
            Command command = new AddProjectCommand(this.projects);
            command.execute(subcommandRest[1]);
        }
        else if (subcommandRest[0].equals("task")){
            Command command = new AddTaskCommand(this.projects);
            command.execute(subcommandRest[1]);
        }
    }
}
