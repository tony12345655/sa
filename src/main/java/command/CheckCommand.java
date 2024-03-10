package command;

import application.TaskApplication;
import project.Project;

import java.util.LinkedHashMap;

public class CheckCommand implements Command{
    @Override
    public String execute(LinkedHashMap<String, Project> projects, String nowCommand, String nextCommand) {
        TaskApplication.getInstance().setTaskDone(nextCommand, true);
        return "";
    }
}
