package useCase.query.helpQuery;

import useCase.dto.HelpDto;
import useCase.port.output.HelpOutput;
import useCase.query.Query;

public class HelpQuery extends Query<HelpOutput> {
    @Override
    public HelpOutput execute(){
        HelpDto helpDto = new HelpDto();
        helpDto.heading = "Commands:";
        helpDto.commands.add("show");
        helpDto.commands.add("add project <project name>");
        helpDto.commands.add("add task <project name> <task description>");
        helpDto.commands.add("check <task ID>");
        helpDto.commands.add("uncheck <task ID>");
        return new HelpOutput(helpDto);
    }
}
