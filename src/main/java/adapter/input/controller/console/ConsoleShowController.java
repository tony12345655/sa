package adapter.input.controller.console;

import adapter.output.presenter.console.ConsoleShowPresenter;
import useCase.port.input.query.NullQueryInput;
import useCase.port.input.query.QueryInput;
import useCase.port.output.query.show.ShowOutput;
import useCase.service.ShowService;

public class ConsoleShowController implements ConsoleController{
    private final ShowService showQuery;
    private final ConsoleShowPresenter presenter;

    public ConsoleShowController(ShowService showQuery, ConsoleShowPresenter consoleShowPresenter){
        this.showQuery = showQuery;
        this.presenter = consoleShowPresenter;
    }

    public void execute(String commandLine){
        QueryInput input = new NullQueryInput();
        ShowOutput showOutput = this.showQuery.execute(input);
        this.presenter.present(showOutput.projectsDto);
    }
}
