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
        Project target_project = null;
        for (Project project : this.projects){
            if (name.equals(project.getName()))
                target_project = project;
        }
        return target_project;
    }
    public List<Project> getProjects(){
        return this.projects;
    }

    public String info(){
        StringBuilder result = new StringBuilder();
        for (Project project : this.projects)
            result.append(project.info());
        return result.toString();
    }

}
