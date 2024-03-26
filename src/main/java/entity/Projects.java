package entity;

import java.util.*;

public class Projects {
    private final List<Project> projects = new ArrayList<>();
    public void addProject(Project project){
        this.projects.add(project);
    }

    public List<Project> getProjects(){
        return Collections.unmodifiableList(this.projects);
    }

    public String info(){
        StringBuilder result = new StringBuilder();
        for (Project project : this.projects)
            result.append(project.info());
        return result.toString();
    }

}
