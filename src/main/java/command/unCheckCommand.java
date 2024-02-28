package command;

import checkList.Iterator.Iterator;
import checkList.Project;

import java.util.LinkedHashMap;

public class unCheckCommand implements  Command{
    private final LinkedHashMap<String, Project> projects;

    public unCheckCommand(LinkedHashMap<String, Project> projects){
        this.projects = projects;
    }

    @Override
    public void execute(String nextCommand) {
        for (String project_name : this.projects.keySet()){
            Project project = this.projects.get(project_name);
            for (Iterator it = project.createIterator(); it.isDone(); it.next()){
                if (it.currentItem().getId() == Long.parseLong(nextCommand))
                    it.currentItem().unCheck();
            }
        }
    }
}
