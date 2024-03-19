package useCase;

import entity.Task;

import java.util.LinkedHashMap;

public class Tasks {
    public static Tasks instance;
    private Tasks(){};
    private final LinkedHashMap<Long, Task> tasks = new LinkedHashMap<>();

    private long tokenId = 1;
    public static Tasks getInstance() {
        if (instance == null)
            instance = new Tasks();
        return instance;
    }
    public Task createTask(String description){
        Task task = new Task(tokenId, description, false);
        this.tasks.put(tokenId, task);
        tokenId++;
        return task;
    }
    public Task getTask(long Id){
        return this.tasks.get(Id);
    }
    public void SetDone(long tokenId, boolean done){
        this.tasks.get(tokenId).setDone(done);
    }
}
