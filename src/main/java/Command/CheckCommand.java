package Command;

import CheckList.Iterator.Iterator;
import CheckList.Project;

import java.util.LinkedHashMap;

public class CheckCommand implements Command{

    private final LinkedHashMap<String, Project> projects;
    private final String idString;
    public CheckCommand(LinkedHashMap<String, Project> projects, String idString){
        this.projects = projects;
        this.idString = idString;
    }
    @Override
    public void execute() {
        for (String project_name : this.projects.keySet()){
            Project project = this.projects.get(project_name);
            for (Iterator it = project.createIterator(); it.isDone(); it.next()){
                if (it.currentItem().getId() == Long.parseLong(this.idString))
                    it.currentItem().check();
            }
        }
    }
}
