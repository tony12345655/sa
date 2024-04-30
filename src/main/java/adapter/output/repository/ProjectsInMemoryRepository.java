package adapter.output.repository;

import entity.*;
import useCase.port.output.projects.ProjectsMapper;
import useCase.port.output.projects.ProjectsRepository;

public class ProjectsInMemoryRepository implements ProjectsRepository {

    private final ProjectsInMemoryRepositoryPeer peer;
    public ProjectsInMemoryRepository(ProjectsInMemoryRepositoryPeer peer){
        this.peer = peer;
    }

    @Override
    public void save(Projects projects) {
        peer.save(ProjectsMapper.toPo(projects));
    }

    @Override
    public Projects getProjects(){
        return ProjectsMapper.toDomain(peer.getProjectsPo());
    }

}
