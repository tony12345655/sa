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

}
