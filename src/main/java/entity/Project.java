package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project {
    private final ProjectName projectName;
    private final List<Task> tasks = new ArrayList<>();
    public Project(ProjectName projectName){
        this.projectName = projectName;
    }
    public void addTask(Task task){
        this.tasks.add(task);
    }
    public List<Task> getTasks(){
        return Collections.unmodifiableList(this.tasks);
    }
    public String getName(){
        return this.projectName.toString();
    }
    public String info(){
        StringBuilder result = new StringBuilder();
        result.append(this.projectName.toString()).append("\r\n");
        for (Task task : this.tasks){
            result.append(task.info());
        }
        result.append("\r\n");
        return result.toString();
    }
}
