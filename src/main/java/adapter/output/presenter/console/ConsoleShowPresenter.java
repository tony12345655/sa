package adapter.output.presenter.console;

import useCase.port.output.projects.dto.ProjectDto;
import useCase.port.output.projects.dto.ProjectsDto;
import useCase.port.output.projects.dto.TaskDto;

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
