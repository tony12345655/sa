package command;

import application.CommandApplication;
import project.Project;

import java.util.LinkedHashMap;

public class AddCommand implements Command{
    @Override
    public String execute(LinkedHashMap<String, Project> projects, String nowCommand, String nextCommand) {
        String[] subcommandRest = nextCommand.split(" ", 2);
        Command command = CommandApplication.getInstance().CreateCommand(subcommandRest[0]);
        command.execute(projects, subcommandRest[0], subcommandRest[1]);
        return "";
    }
}
