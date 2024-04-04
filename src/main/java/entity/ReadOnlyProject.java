package entity;

import java.util.ArrayList;
import java.util.List;

public class ReadOnlyProject extends Project{
    public ReadOnlyProject(ProjectName name, List<Task> tasks){
        super(name, tasks);
    }

    @Override
    public void addTask(Task task){
        throw new RuntimeException("Cannot modify task because it is readonly");
    }

    @Override
    public List<Task> getTasks(){
        List<Task> readOnlyTasks = new ArrayList<>();
        for (Task task : super.getTasks())
            readOnlyTasks.add(new ReadOnlyTask(task.getId(), task.getDescription(), task.isDone()));
        return readOnlyTasks;
    }

}
