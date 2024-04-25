package useCase.port.output.projects;

import entity.Projects;

public interface ProjectsRepository {
    void save(Projects projects);
    Projects getProjects();
}
