package adapter.input.controller.console;

import useCase.port.input.query.NullQueryInput;
import useCase.port.input.query.QueryInput;
import useCase.port.output.query.help.HelpOutput;
import useCase.port.output.query.help.HelpDto;
import useCase.query.HelpQuery;

public class ConsoleHelpController {
    private final HelpQuery helpQuery;
    public ConsoleHelpController(HelpQuery helpQuery){
        this.helpQuery = helpQuery;
    }
    public HelpDto execute(){
        QueryInput input = new NullQueryInput();
        HelpOutput helpOutput = this.helpQuery.execute(input);
        return helpOutput.helpDto;
    }
}
