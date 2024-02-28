package Command;

import CheckList.Iterator.Iterator;
import CheckList.Project;

import java.util.LinkedHashMap;

public class CheckCommand implements Command{

    private final LinkedHashMap<String, Project> projects;
    public CheckCommand(LinkedHashMap<String, Project> projects){
        this.projects = projects;
    }
    @Override
    public void execute(String nextCommand) {
        for (String project_name : this.projects.keySet()){
            Project project = this.projects.get(project_name);
            for (Iterator it = project.createIterator(); it.isDone(); it.next()){
                if (it.currentItem().getId() == Long.parseLong(nextCommand))
                    it.currentItem().check();
            }
        }
    }
}
