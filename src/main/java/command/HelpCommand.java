package command;

import output.Out;

public class HelpCommand implements Command{
    @Override
    public void execute(String nextCommand) {
        Out.getInstance().println("Commands:");
        Out.getInstance().println("  show");
        Out.getInstance().println("  add project <project name>");
        Out.getInstance().println("  add task <project name> <task description>");
        Out.getInstance().println("  check <task ID>");
        Out.getInstance().println("  uncheck <task ID>");
        Out.getInstance().println();
    }
}
