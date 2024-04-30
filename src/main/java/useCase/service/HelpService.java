package useCase.service;

import useCase.port.input.query.Help.HelpUseCase;
import useCase.port.output.query.help.HelpDto;
import useCase.port.input.query.QueryInput;
import useCase.port.output.query.help.HelpOutput;

public class HelpService implements HelpUseCase {
    @Override
    public HelpOutput execute(QueryInput input){
        HelpDto helpDto = new HelpDto();
        helpDto.heading = "Commands:";
        helpDto.commands.add("show");
        helpDto.commands.add("add project <project name>");
        helpDto.commands.add("add task <project name> <task description>");
        helpDto.commands.add("check <task ID>");
        helpDto.commands.add("uncheck <task ID>");
        HelpOutput helpOutput = new HelpOutput();
        helpOutput.helpDto = helpDto;
        return helpOutput;
    }
}
