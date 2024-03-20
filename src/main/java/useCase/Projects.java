package useCase;

import entity.Project;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Projects {

    private static Projects instance = null;

    private final LinkedHashMap<String, Project> projects = new LinkedHashMap<>();

    private Projects(){};

    public static Projects getInstance() {
        if (instance == null)
            instance = new Projects();
        return instance;
    }
    public void createProject(String name){
        Project project = new Project(name);
        this.projects.put(name, project);
    }
    public Project getProject(String name){
        return this.projects.get(name);
    }
    public String showProjects(){
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Project> project : this.projects.entrySet()){
            result.append(project.getValue().show());
        }
        return result.toString();
    }
}
