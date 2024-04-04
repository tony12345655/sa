package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project {
    private final ProjectName name;
    private final List<Task> tasks = new ArrayList<>();
    public Project(ProjectName name){
        this.name = name;
    }
    public void addTask(Task task){
        this.tasks.add(task);
    }
    public List<Task> getTasks(){
        return Collections.unmodifiableList(this.tasks);
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
