package CheckList;

public class Task implements CheckList{

    private final long id;
    private final String description;
    private boolean done;
    public Task(long id, String description){
        this.id = id;
        this.description = description;
    }
    @Override
    public void add(CheckList checkList){
        throw new Error("Task is not add!");
    }

    @Override
    public void check() {
        this.done = true;
    }

    @Override
    public void unCheck() {
        this.done = false;
    }

    @Override
    public boolean isDone() {
        return this.done;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}