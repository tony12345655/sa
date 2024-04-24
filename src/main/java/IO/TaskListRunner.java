package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import adapter.controller.ConsoleController;
import adapter.presenter.ConsolePresenter;
import useCase.command.*;
import useCase.port.output.CommandOutput;
import useCase.repository.ProjectsRepository;


public final class TaskListRunner implements Runnable {
    private static final String QUIT = "quit";
    private final BufferedReader in;
    private final PrintWriter out;

    private final ProjectsRepository projectsRepository = new ProjectsRepository();
    private final ConsoleController consoleController = new ConsoleController(
            new AddCommand(projectsRepository),
            new CheckCommand(projectsRepository),
            new UnCheckCommand(projectsRepository),
            new HelpCommand(),
            new ShowCommand(projectsRepository),
            new ErrorCommand());

    private final ConsolePresenter consolePresenter = new ConsolePresenter();

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
                CommandOutput out = this.consoleController.execute(commandLine);
                this.consolePresenter.execute(out, this.out);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (commandLine.equals(QUIT))
                break;

        }
    }
}
