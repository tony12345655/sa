package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project {
    private final ProjectDescription projectDescription;
    private final List<Task> tasks = new ArrayList<>();
    public Project(ProjectDescription projectDescription){
        this.projectDescription = projectDescription;
    }
    public void addTask(Task task){
        this.tasks.add(task);
    }
    public List<Task> getTasks(){
        return Collections.unmodifiableList(this.tasks);
    }
    public String getName(){
        return this.projectDescription.getProjectName();
    }
    public String info(){
        StringBuilder result = new StringBuilder();
        result.append(this.projectDescription.getProjectName()).append("\r\n");
        for (Task task : this.tasks){
            result.append(task.info());
        }
        result.append("\r\n");
        return result.toString();
    }
}
