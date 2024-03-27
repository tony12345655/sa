package useCase.model;

import entity.Project;
import entity.ProjectDescription;
import entity.Projects;
import entity.Task;
public class ProjectsModel {
    private long taskId = 1;
    private final Projects projects = new Projects();

    public Project getProject(String projectName){
        Project target_project = null;
        for (Project project : this.projects.getProjects()){
            if (project.getName().equals(projectName))
                target_project = project;
        }
        return target_project;
    }

    public String getProjectsInfo(){
        return this.projects.info();
    }

    public void addProject(String name){
        ProjectDescription projectName = new ProjectDescription(name);
        Project project = new Project(projectName);
        this.projects.addProject(project);
    }

    public void addTaskToProject(String projectName, String taskDescription){
        Task task = new Task(taskId, taskDescription, false);
        Project project = this.getProject(projectName);
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
