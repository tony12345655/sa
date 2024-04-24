package adapter.controller;

import useCase.port.output.HelpOutput;
import useCase.dto.HelpDto;
import useCase.query.helpQuery.HelpQuery;

public class HelpController {
    private final HelpQuery helpQuery;
    public HelpController(HelpQuery helpQuery){
        this.helpQuery = helpQuery;
    }
    public HelpDto execute(){
        HelpOutput helpOutput = this.helpQuery.execute();
        return helpOutput.helpDto;
    }
}
