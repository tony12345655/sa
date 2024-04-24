package adapter.presenter.console;

import adapter.controller.CommandController;
import useCase.port.output.CommandOutput;

import java.io.PrintWriter;

public class ConsoleCommandPresenter {
    private final PrintWriter out;

    public ConsoleCommandPresenter(PrintWriter out){
        this.out = out;
    }

    public void present(String message){
        this.out.println(message);
    }
}
