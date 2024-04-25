package useCase.port.output.projects;

import entity.Project;
import entity.Projects;
import useCase.port.output.projects.dto.ProjectsDto;
import useCase.port.output.projects.po.ProjectPo;
import useCase.port.output.projects.po.ProjectsPo;

import java.util.List;

public class ProjectsMapper {
    public static ProjectsDto toDto(Projects projects) {
        ProjectsDto projectsDto = new ProjectsDto();
        projectsDto.projectDtos = ProjectMapper.toDto(projects.getProjects());
        return projectsDto;
    }

    public static ProjectsPo toPo(Projects projects){
        return new ProjectsPo(ProjectMapper.toPo(projects.getProjects()), projects.getLstTaskId());
    }

    public static Projects toDomain(ProjectsPo projectsPo){
       return new Projects(ProjectMapper.toDomain(projectsPo.getProjectPos()), projectsPo.getLastTaskId());
    }
}
