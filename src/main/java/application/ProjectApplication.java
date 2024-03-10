package application;

import project.Project;

public class ProjectApplication {
    private static ProjectApplication instance;

    public static ProjectApplication getInstance(){
        if (instance == null)
            instance = new ProjectApplication();
        return  instance;
    }

    public Project createProject(String name){
        return new Project(name);
    }
}
