package entity;

import entity.Task;

import java.util.ArrayList;

public class Project {
    private final ArrayList<Task> tasks = new ArrayList<>();
    public void AddTask(Task task){
        this.tasks.add(task);
    }
    public ArrayList<Task> getTasks(){
        return this.tasks;
    }


}
