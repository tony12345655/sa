package useCase.port.output.projects.po;

import java.util.ArrayList;
import java.util.List;

public class ProjectsPo {
    private final List<ProjectPo> projectPos;
    private final long lastTaskId;

    public ProjectsPo(){
        this.projectPos = new ArrayList<>();
        this.lastTaskId = 1;
    }

    public ProjectsPo(List<ProjectPo> projectPos, long lastTaskId){
        this.lastTaskId = lastTaskId;
        this.projectPos = projectPos;
    }

    public List<ProjectPo> getProjectPos() {
        return projectPos;
    }

    public long getLastTaskId() {
        return lastTaskId;
    }
}
