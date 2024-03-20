package useCase.command;

import entity.Task;
import useCase.Tasks;

public class UnCheckCommand implements  Command{
    private final long taskId;

    public UnCheckCommand(String nextCommand){
        String[] commandRest = nextCommand.split(" ", 2);
        this.taskId = Long.parseLong(commandRest[0]);
    }
    @Override
    public String execute() {
        Tasks.getInstance().setDone(this.taskId, false);
        return "";
    }
}
