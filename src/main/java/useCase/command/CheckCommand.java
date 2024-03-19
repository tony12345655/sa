package useCase.command;

import useCase.Tasks;
public class CheckCommand implements Command{
    private final long taskId;

    public CheckCommand(String nextCommand){
        String[] commandRest = nextCommand.split(" ", 2);
        this.taskId = Long.parseLong(commandRest[0]);
    }
    @Override
    public String execute() {
        Tasks.getInstance().SetDone(this.taskId, true);
        return "";
    }
}
