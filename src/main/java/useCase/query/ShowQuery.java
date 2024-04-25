package useCase.query;

import entity.Projects;
import useCase.port.output.projects.dto.ProjectsDto;
import useCase.port.output.projects.ProjectsMapper;
import useCase.port.input.query.QueryInput;
import useCase.port.output.query.show.ShowOutput;
import adapter.output.presenter.repository.ProjectsInMemoryRepository;

public class ShowQuery implements Query<ShowOutput> {

    private final ProjectsInMemoryRepository projectsRepository;
    public ShowQuery(ProjectsInMemoryRepository projectsRepository){
        this.projectsRepository = projectsRepository;
    }
    @Override
    public ShowOutput execute(QueryInput input) {
        Projects projects = this.projectsRepository.getProjects();
        ProjectsDto projectsDto = ProjectsMapper.toDto(projects);
        ShowOutput showOutput = new ShowOutput();
        showOutput.projectsDto = projectsDto;
        return showOutput;
    }
}
