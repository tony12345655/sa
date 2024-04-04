package entity;

import java.util.ArrayList;
import java.util.List;

public class ReadOnlyProjects extends Projects{
    public ReadOnlyProjects(List<Project> projects){
        super(projects);
    }

    @Override
    public void addProject(Project project){
        throw new RuntimeException("Cannot modify task because it is readonly");
    }

    @Override
    public Project getProject(ProjectName name){
        throw new RuntimeException("Cannot modify task because it is readonly");
    }

    @Override
    public List<Project> getProjects(){
        List<Project> readOnlyProjects = new ArrayList<>();
        for (Project project : super.getProjects())
            readOnlyProjects.add(new ReadOnlyProject(project.getName(), project.getTasks()));
        return readOnlyProjects;
    }
}
