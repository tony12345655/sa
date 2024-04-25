package useCase.port.output.projects.dto;

import entity.ProjectName;

import java.util.List;

public class ProjectDto {

    public ProjectName name;
    public List<TaskDto> taskDtos;
}
