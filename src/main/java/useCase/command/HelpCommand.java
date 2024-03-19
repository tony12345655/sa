package useCase.command;

import entity.Project;

import java.util.LinkedHashMap;

public class HelpCommand implements Command{
    @Override
    public String execute(){
        return "Commands:" + '\n' + "  show" + '\n' + "  add project <project name>" + '\n' + "  add task <project name> <task description>" + '\n' + "  check <task ID>" + '\n' + "  uncheck <task ID>" + '\n';
    }
}
