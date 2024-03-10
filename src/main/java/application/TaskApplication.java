package application;
import project.Task;
import java.util.LinkedHashMap;

public class TaskApplication {
    private static TaskApplication instance;

    private final static LinkedHashMap<String, Task> tasks = new LinkedHashMap<>();
    private long taskId = 0;

    public static TaskApplication getInstance(){
        if (instance == null)
            instance = new TaskApplication();
        return  instance;
    }

    public Task createTask(String description){
        this.taskId++;
        Task task = new Task(taskId, description, false);
        tasks.put(Long.toString(taskId), task);
        return task;
    }

    public void setTaskDone(String id, boolean done){
        Task task = tasks.get(id);
        task.setDone(done);
    }
}
