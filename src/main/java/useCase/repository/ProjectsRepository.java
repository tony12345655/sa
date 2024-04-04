package useCase.repository;

import entity.*;

import java.util.ArrayList;

public class ProjectsRepository {
    private long taskId = 1;
    private final Projects projects = new Projects(new ArrayList<>());

    public Project getProject(ProjectName name){
        Project target_project = null;
        for (Project project : this.projects.getProjects()){
            if (project.getName().equals(name))
                target_project = new ReadOnlyProject(project.getName(), project.getTasks());
        }
        return target_project;
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
        Project project = this.projects.getProject(name);
        if (project != null){
            project.addTask(task);
            this.taskId++;
        }
    }

    public void setTaskDone(long taskId, boolean done){
        for (Project project : projects.getProjects()){
            for (Task task : project.getTasks()){
                if (task.getId() == taskId)
                    task.setDone(done);
            }
        }
    }
}
