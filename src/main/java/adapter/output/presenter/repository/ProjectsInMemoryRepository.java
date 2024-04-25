package adapter.output.presenter.repository;

import entity.*;
import useCase.port.output.projects.ProjectsMapper;
import useCase.port.output.projects.ProjectsRepository;
import useCase.port.output.projects.po.ProjectsPo;

public class ProjectsInMemoryRepository implements ProjectsRepository {
    private ProjectsPo projectsPo = new ProjectsPo();

    @Override
    public void save(Projects projects) {
        this.projectsPo = ProjectsMapper.toPo(projects);
    }

    @Override
    public Projects getProjects(){
        return ProjectsMapper.toDomain(this.projectsPo);
    }

}
