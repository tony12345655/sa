package adapter.controller;

import useCase.dto.projects.ProjectsDto;
import useCase.port.input.query.NullQueryInput;
import useCase.port.input.query.QueryInput;
import useCase.port.output.ShowOutput;
import useCase.query.ShowQuery;

public class ShowController {
    private final ShowQuery showQuery;

    public ShowController(ShowQuery showQuery){
        this.showQuery = showQuery;
    }

    public ProjectsDto execute(){
        QueryInput input = new NullQueryInput();
        ShowOutput showOutput = this.showQuery.execute(input);
        return showOutput.projectsDto;
    }
}
