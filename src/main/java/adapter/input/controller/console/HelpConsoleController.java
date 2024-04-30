package adapter.input.controller.console;

import adapter.output.presenter.console.ConsoleHelpPresenter;
import useCase.port.input.query.NullQueryInput;
import useCase.port.input.query.QueryInput;
import useCase.port.output.query.help.HelpOutput;
import useCase.service.HelpService;

public class HelpConsoleController implements ConsoleController{
    private final HelpService helpQuery;
    private final ConsoleHelpPresenter presenter;
    public HelpConsoleController(HelpService helpQuery, ConsoleHelpPresenter consoleHelpPresenter){
        this.helpQuery = helpQuery;
        this.presenter = consoleHelpPresenter;
    }
    public void execute(String commandLine){
        QueryInput input = new NullQueryInput();
        HelpOutput helpOutput = this.helpQuery.execute(input);
        this.presenter.present(helpOutput.helpDto);
    }
}
