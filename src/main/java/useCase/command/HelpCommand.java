package useCase.command;

import useCase.port.input.CommandInput;
import useCase.port.output.CommandOutput;

public class HelpCommand implements Command{
    @Override
    public CommandOutput execute(CommandInput commandInput){
        return new CommandOutput("""
                Commands:
                  show
                  add project <project name>
                  add task <project name> <task description>
                  check <task ID>
                  uncheck <task ID>
                """);
    }
}
