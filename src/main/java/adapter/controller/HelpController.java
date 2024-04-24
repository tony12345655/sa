package adapter.controller;

import useCase.port.input.query.NullQueryInput;
import useCase.port.input.query.QueryInput;
import useCase.port.output.HelpOutput;
import useCase.dto.HelpDto;
import useCase.query.HelpQuery;

public class HelpController {
    private final HelpQuery helpQuery;
    public HelpController(HelpQuery helpQuery){
        this.helpQuery = helpQuery;
    }
    public HelpDto execute(){
        QueryInput input = new NullQueryInput();
        HelpOutput helpOutput = this.helpQuery.execute(input);
        return helpOutput.helpDto;
    }
}
