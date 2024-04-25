package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReadOnlyProjects extends Projects{
    public ReadOnlyProjects(List<Project> projects, long lastTaskId){
        super(projects, lastTaskId);
    }

    @Override
    public void addProject(ProjectName projectName){
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
