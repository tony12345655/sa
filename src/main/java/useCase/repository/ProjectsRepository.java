package useCase.repository;

import entity.*;

import java.util.ArrayList;

public class ProjectsRepository {
    private long taskId = 1;
    private final Projects projects = new Projects(new ArrayList<>());

    public Project getProject(ProjectName name){
      return this.projects.getProject(name);
    }

    public String getProjectsInfo(){
        return this.projects.info();
    }

    public void addProject(ProjectName name){
        Project project = new Project(name, new ArrayList<>());
        this.projects.addProject(project);
    }

    public void addTaskToProject(ProjectName name, String taskDescription){
        Task task = new Task(taskId, taskDescription, false);
        boolean status = this.projects.addTaskToProject(name, task);
        if (status)
            this.taskId++;
    }

    public void setTaskDone(long taskId, boolean done){
        this.projects.setTaskDone(taskId, done);
    }
}
