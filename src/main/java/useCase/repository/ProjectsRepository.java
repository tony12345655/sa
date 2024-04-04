package useCase.repository;

import entity.Project;
import entity.ProjectName;
import entity.Projects;
import entity.Task;
public class ProjectsRepository {
    private long taskId = 1;
    private final Projects projects = new Projects();

    public Project getProject(ProjectName name){
        Project target_project = null;
        for (Project project : this.projects.getProjects()){
            if (project.getName().equals(name))
                target_project = project;
        }
        return target_project;
    }

    public String getProjectsInfo(){
        return this.projects.info();
    }

    public void addProject(String name){
        Project project = new Project(ProjectName.of(name));
        this.projects.addProject(project);
    }

    public void addTaskToProject(ProjectName name, String taskDescription){
        Task task = new Task(taskId, taskDescription, false);
        Project project = this.getProject(name);
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
