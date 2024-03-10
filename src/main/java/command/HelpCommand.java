package command;

import project.Project;

import java.util.LinkedHashMap;

public class HelpCommand implements Command{
    @Override
    public String execute(LinkedHashMap<String, Project> projects, String nowCommand, String nextCommand){
        return "Commands:" + '\n' + "  show" + '\n' + "  add project <project name>" + '\n' + "  add task <project name> <task description>" + '\n' + "  check <task ID>" + '\n' + "  uncheck <task ID>" + '\n';
    }
}
