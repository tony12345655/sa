package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import adapter.controller.CommandController;
import adapter.presenter.TaskListPresenter;
import useCase.repository.ProjectsRepository;


public final class TaskListRunner implements Runnable {
    private static final String QUIT = "quit";
    private final BufferedReader in;
    private final PrintWriter out;
    private final CommandController commandController = new CommandController(new ProjectsRepository());

    public static void main(String[] args){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskListRunner(in, out).run();
    }

    public TaskListRunner(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;

    }

    public void run() {
        while (true) {
            this.out.print("> ");
            this.out.flush();
            String commandLine;
            try {
                commandLine = this.in.readLine();
                String result = this.commandController.execute(commandLine);
                TaskListPresenter taskListPresenter = new TaskListPresenter();
                taskListPresenter.execute(result, this.out);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (commandLine.equals(QUIT))
                break;

        }
    }
}
