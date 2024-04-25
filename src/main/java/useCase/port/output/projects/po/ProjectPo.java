package useCase.port.output.projects.po;

import entity.ProjectName;
import entity.Projects;

import java.util.ArrayList;
import java.util.List;

public class ProjectPo {
    private final ProjectName name;
    private final List<TaskPo> taskPos;

    public ProjectPo(ProjectName name, List<TaskPo> taskPos){
        this.name = name;
        this.taskPos = taskPos;
    }

    public ProjectName getName() {
        return this.name;
    }

    public List<TaskPo> getTaskPos() {
        return this.taskPos;
    }
}
