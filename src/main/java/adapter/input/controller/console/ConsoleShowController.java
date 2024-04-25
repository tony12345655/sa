package adapter.input.controller.console;

import useCase.port.output.projects.dto.ProjectsDto;
import useCase.port.input.query.NullQueryInput;
import useCase.port.input.query.QueryInput;
import useCase.port.output.query.show.ShowOutput;
import useCase.query.ShowQuery;

public class ConsoleShowController {
    private final ShowQuery showQuery;

    public ConsoleShowController(ShowQuery showQuery){
        this.showQuery = showQuery;
    }

    public ProjectsDto execute(){
        QueryInput input = new NullQueryInput();
        ShowOutput showOutput = this.showQuery.execute(input);
        return showOutput.projectsDto;
    }
}
