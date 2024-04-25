package entity;

import java.util.*;

public class Projects {
    private final List<Project> projects;
    private long lstTaskId;
    public Projects(List<Project> projects, long lstTaskId){
        this.projects = projects;
        this.lstTaskId = lstTaskId;
    }

    public Projects(){
        this.projects = new ArrayList<>();
        this.lstTaskId = 1;
    }

    public void addProject(ProjectName name){
        Project project = new Project(name, new ArrayList<>());
        this.projects.add(project);
    }

    public Project getProject(ProjectName name){
        Optional<Project> p = this.projects.stream().filter(project -> project.getName().equals(name)).findFirst();
        return p.map(project -> new ReadOnlyProject(project.getName(), project.getTasks())).orElse(null);
    }

    public List<Project> getProjects(){
        return this.projects.stream().map(project -> (Project)  new ReadOnlyProject(project.getName(), project.getTasks())).toList();
    }

    public void setTaskDone(long taskId, boolean done){
        for (Project project : this.projects){
            Optional<Task> t = project.getTasks().stream().filter(task -> task.getId() == taskId).findFirst();
            t.ifPresent(task -> task.setDone(done));
        }
    }

    public void addTaskToProject(ProjectName name, String description, boolean done){
        Task task = new Task(this.lstTaskId, description, done);
        Optional<Project> p = projects.stream().filter(project -> project.getName().equals(name)).findFirst();
        p.ifPresent(project -> project.addTask(task));
        this.lstTaskId++;
    }

    public long getLstTaskId(){
        return this.lstTaskId;
    }

}
