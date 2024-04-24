package adapter.presenter.console;

import entity.Project;
import entity.Projects;
import useCase.dto.projects.ProjectDto;
import useCase.dto.projects.ProjectsDto;
import useCase.dto.projects.TaskDto;
import useCase.port.output.ShowOutput;

import java.io.PrintWriter;

public class ConsoleShowPresenter {
    private final PrintWriter out;

    public ConsoleShowPresenter(PrintWriter out){
        this.out = out;
    }

    public void present(ProjectsDto projectsDto){
        for (ProjectDto projectDto : projectsDto.projectDtos){
            this.out.println(projectDto.name);
            for (TaskDto taskDto : projectDto.taskDtos){
                this.out.printf("    [%c] %d: %s%n", (taskDto.done ? 'x' : ' '), taskDto.Id, taskDto.description);
            }
            this.out.println();
        }
    }
}
