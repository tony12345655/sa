package useCase.service;

import entity.Projects;
import useCase.port.input.query.Show.ShowUseCase;
import useCase.port.output.projects.dto.ProjectsDto;
import useCase.port.output.projects.ProjectsMapper;
import useCase.port.input.query.QueryInput;
import useCase.port.output.query.show.ShowOutput;
import adapter.output.repository.ProjectsInMemoryRepository;

public class ShowService implements ShowUseCase {

    private final ProjectsInMemoryRepository projectsRepository;
    public ShowService(ProjectsInMemoryRepository projectsRepository){
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
