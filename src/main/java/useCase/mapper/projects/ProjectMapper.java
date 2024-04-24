package useCase.mapper.projects;

import entity.Project;
import useCase.dto.projects.ProjectDto;
import useCase.dto.projects.ProjectsDto;

import java.util.List;

public class ProjectMapper {

    public static ProjectDto toDto(Project project){
        ProjectDto projectDto = new ProjectDto();
        projectDto.name = project.getName();
        projectDto.taskDtos = TaskMapper.toDto(project.getTasks());
        return projectDto;
    }

    public static List<ProjectDto> toDto(List<Project> projects){
        return projects.stream().map(ProjectMapper::toDto).toList();
    }
}
