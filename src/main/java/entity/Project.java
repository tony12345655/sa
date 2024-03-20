package entity;

import entity.Task;

import java.util.ArrayList;

public class Project {
    private final String name;
    private final ArrayList<Task> tasks = new ArrayList<>();
    public Project(String name){
        this.name = name;
    }
    public void AddTask(Task task){
        this.tasks.add(task);
    }
    public ArrayList<Task> getTasks(){
        return this.tasks;
    }
    public String show(){
        StringBuilder result = new StringBuilder();
        result.append(this.name).append("\r\n");
        for (Task task : this.tasks){
            result.append(task.show());
        }
        result.append("\r\n");
        return result.toString();
    }
}
