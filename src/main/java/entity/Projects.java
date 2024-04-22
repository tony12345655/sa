package entity;

import java.util.*;

public class Projects {
    private final List<Project> projects;
    public Projects(List<Project> projects){
        this.projects = projects;
    }

    public void addProject(Project project){
        this.projects.add(project);
    }

    public Project getProject(ProjectName name){
        Optional<Project> p = projects.stream().filter(project -> project.getName().equals(name)).findFirst();
        return p.map(project -> new ReadOnlyProject(project.getName(), project.getTasks())).orElse(null);
    }

    public void setTaskDone(long taskId, boolean done){
        for (Project project : this.projects){
            Optional<Task> t = project.getTasks().stream().filter(task -> task.getId() == taskId).findFirst();
            t.ifPresent(task -> task.setDone(done));
        }
    }

    public boolean addTaskToProject(ProjectName name, Task task){
        Optional<Project> p = projects.stream().filter(project -> project.getName().equals(name)).findFirst();
        if (p.isEmpty())
            return false;
        else{
            p.get().addTask(task);
            return true;
        }
    }

    public String info(){
        StringBuilder result = new StringBuilder();
        for (Project project : this.projects)
            result.append(project.info());
        return result.toString();
    }

}
