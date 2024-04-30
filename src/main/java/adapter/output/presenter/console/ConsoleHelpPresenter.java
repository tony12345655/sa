package adapter.output.presenter.console;

import useCase.port.output.query.help.HelpDto;
import useCase.port.output.query.help.HelpPresenter;

import java.io.PrintWriter;

public class ConsoleHelpPresenter implements HelpPresenter {
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
