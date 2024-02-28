package checkList;

public class CheckListFactory {
    private static CheckListFactory instance;
    private long taskId = 0;
    private CheckListFactory(){

    }
    public static CheckListFactory getInstance(){
        if (instance == null)
            instance = new CheckListFactory();
        return  instance;
    }
    public Task createTask(String description){
        this.taskId++;
        return new Task(this.taskId, description);
    }

    public Project createProject(String name){
        return new Project(0, name);
    }
}
