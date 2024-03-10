package project;

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
    public String getName(){
        return this.name;
    }
    public ArrayList<Task> getTasks(){
        return this.tasks;
    }


}
