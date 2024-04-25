package useCase.port.output.projects;

import entity.Project;
import useCase.port.output.projects.dto.ProjectDto;
import useCase.port.output.projects.po.ProjectPo;

import java.util.List;
import java.util.stream.Collectors;

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

    public static ProjectPo toPo(Project project){
        return new ProjectPo(project.getName(), TaskMapper.toPo(project.getTasks()));
    }

    public static List<ProjectPo> toPo(List<Project> projects){
        return projects.stream().map(ProjectMapper::toPo).collect(Collectors.toList());
    }

    public static Project toDomain(ProjectPo projectPo){
        return new Project(projectPo.getName(), TaskMapper.toDomain(projectPo.getTaskPos()));
    }

    public static  List<Project> toDomain(List<ProjectPo> projectPos){
        return projectPos.stream().map(ProjectMapper::toDomain).collect(Collectors.toList());
    }
}
