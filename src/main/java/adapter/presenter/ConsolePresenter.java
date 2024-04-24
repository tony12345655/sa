package adapter.presenter;

import useCase.port.output.CommandOutput;

import java.io.PrintWriter;

public class ConsolePresenter {
    public void execute(CommandOutput out, PrintWriter writer){
        writer.print(out.message);
    }
}
