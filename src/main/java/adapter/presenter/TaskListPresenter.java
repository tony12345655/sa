package adapter.presenter;

import java.io.PrintWriter;

public class TaskListPresenter {
    public void execute(String result, PrintWriter out){
        out.print(result);
    }
}
