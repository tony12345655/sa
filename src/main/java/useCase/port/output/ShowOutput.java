package useCase.port.output;

import useCase.dto.projects.ProjectsDto;

public class ShowOutput {
    public ProjectsDto projectsDto;

    public ShowOutput(ProjectsDto projectsDto){
        this.projectsDto = projectsDto;
    }
}
