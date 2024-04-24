package adapter.presenter.console;

import useCase.query.helpQuery.HelpDto;

import java.io.PrintWriter;

public class ConsoleHelpPresenter {

    private final PrintWriter out;
    public ConsoleHelpPresenter(PrintWriter out){
        this.out = out;
    }
    public void present(HelpDto helpDto){
        out.println(helpDto.heading);
        for(var command : helpDto.commands)
            out.printf("  %s%n", command);
        out.println();
    }
}
