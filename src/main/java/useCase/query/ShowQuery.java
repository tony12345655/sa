package useCase.query;

import useCase.dto.projects.ProjectsDto;
import useCase.mapper.projects.ProjectsMapper;
import useCase.port.input.query.QueryInput;
import useCase.port.output.ShowOutput;
import useCase.repository.ProjectsRepository;

public class ShowQuery implements Query<ShowOutput> {

    private final ProjectsRepository projectsRepository;
    public ShowQuery(ProjectsRepository projectsRepository){
        this.projectsRepository = projectsRepository;
    }
    @Override
    public ShowOutput execute(QueryInput input) {
        ProjectsDto projectsDto = ProjectsMapper.toDto(this.projectsRepository.getProjects());
        return new ShowOutput(projectsDto);
    }
}
