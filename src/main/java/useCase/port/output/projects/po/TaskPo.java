package useCase.port.output.projects.po;

public class TaskPo {
    private long id;
    private String description;
    private boolean done;

    public TaskPo(long id, String description, boolean done){
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isDone(){
        return this.done;
    }
}
