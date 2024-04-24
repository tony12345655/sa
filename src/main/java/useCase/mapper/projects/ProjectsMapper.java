package useCase.mapper.projects;

import entity.Project;
import entity.Projects;
import useCase.dto.projects.ProjectsDto;

import java.util.List;

public class ProjectsMapper {
    public static ProjectsDto toDto(List<Project> projects) {
        ProjectsDto projectsDto = new ProjectsDto();
        projectsDto.projectDtos = ProjectMapper.toDto(projects);
        return projectsDto;
    }
}
