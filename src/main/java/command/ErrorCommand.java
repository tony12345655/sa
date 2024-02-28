package command;

import output.Out;

public class ErrorCommand implements Command{

    private final String unKnowCommand;
    public ErrorCommand(String unKnowCommand){
        this.unKnowCommand = unKnowCommand;
    }
    @Override
    public void execute(String nextCommand) {
        Out.getInstance().printf("I don't know what the command \"%s\" is.", this.unKnowCommand);
        Out.getInstance().println();
    }
}
