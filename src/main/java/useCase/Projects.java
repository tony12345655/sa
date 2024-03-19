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
        Project project = new Project();
        this.projects.put(name, project);
    }

    public Project getProject(String name){
        return this.projects.get(name);
    }

    public Set<Map.Entry<String, Project>> entrySet(){
        return this.projects.entrySet();
    }
}
