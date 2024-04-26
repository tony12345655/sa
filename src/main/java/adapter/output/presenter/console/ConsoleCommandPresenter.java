package adapter.output.presenter.console;

import java.io.PrintWriter;

public class ConsoleCommandPresenter {
    private final PrintWriter out;

    public ConsoleCommandPresenter(PrintWriter out){
        this.out = out;
    }

    public void present(String message){
        if (message != null)
            this.out.println(message);
    }
}
