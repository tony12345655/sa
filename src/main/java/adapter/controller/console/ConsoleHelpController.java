package adapter.controller.console;

import adapter.presenter.console.ConsoleHelpPresenter;
import useCase.port.output.HelpOutput;
import useCase.query.helpQuery.HelpDto;
import useCase.query.helpQuery.HelpQuery;

public class ConsoleHelpController {
    public HelpDto execute(){
        HelpQuery helpQuery = new HelpQuery();
        HelpOutput helpOutput = helpQuery.execute();
        return helpOutput.helpDto;
    }
}
