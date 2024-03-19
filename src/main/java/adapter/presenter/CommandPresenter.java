package adapter.presenter;

import IO.IO;
import useCase.command.Command;

public class CommandPresenter {
    public void execute(Command command, IO io){
        String result = command.execute();
        io.output(result);
    }
}
