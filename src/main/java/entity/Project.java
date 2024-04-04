package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project {
    private final ProjectName name;
    private final List<Task> tasks;
    public Project(ProjectName name, List<Task> tasks){
        this.name = name;
        this.tasks = tasks;
    }
    public void addTask(Task task){
        this.tasks.add(task);
    }
    public List<Task> getTasks(){
        return this.tasks;
    }
    public ProjectName getName(){
        return name;
    }
    public String info(){
        StringBuilder result = new StringBuilder();
        result.append(this.name.toString()).append("\r\n");
        for (Task task : this.tasks){
            result.append(task.info());
        }
        result.append("\r\n");
        return result.toString();
    }
}
