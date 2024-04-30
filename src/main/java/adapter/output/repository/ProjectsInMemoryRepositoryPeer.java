package adapter.output.repository;

import entity.Projects;
import useCase.port.output.projects.po.ProjectsPo;

import java.util.List;

public class ProjectsInMemoryRepositoryPeer {

    private ProjectsPo projectsPo;

    public ProjectsInMemoryRepositoryPeer(){
        this.projectsPo = new ProjectsPo();
    }

    public void save(ProjectsPo projectsPo){
        this.projectsPo = projectsPo;
    }

    public ProjectsPo getProjectsPo(){
        return this.projectsPo;
    }
}
