package useCase.port.output;

import useCase.query.helpQuery.HelpDto;

public class HelpOutput {
    public HelpDto helpDto;

    public HelpOutput(HelpDto helpDto){
        this.helpDto = helpDto;
    }
}
