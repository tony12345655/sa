package adapter.output.presenter.console;

import useCase.port.output.command.CommandPresenter;

import java.io.PrintWriter;

public class ConsoleCommandPresenter implements CommandPresenter {
    private final PrintWriter out;

    public ConsoleCommandPresenter(PrintWriter out){
        this.out = out;
    }

    public void present(String message){
        if (message != null)
            this.out.println(message);
    }
}
