package useCase.port.output.query.show;

import useCase.port.output.projects.dto.ProjectsDto;

public interface ShowPresenter {
    void present(ProjectsDto projectsDto);
}
