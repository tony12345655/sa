package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public void setTaskDone(long taskId, boolean done){
        throw new RuntimeException("Cannot modify task because it is readonly");
    }
}
