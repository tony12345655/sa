package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import adapter.input.controller.console.ConsoleCommandController;
import adapter.input.controller.console.ConsoleHelpController;
import adapter.input.controller.console.ConsoleShowController;
import adapter.output.presenter.console.ConsoleCommandPresenter;
import adapter.output.presenter.console.ConsoleHelpPresenter;
import adapter.output.presenter.console.ConsoleShowPresenter;
import useCase.command.*;
import useCase.query.HelpQuery;
import useCase.query.ShowQuery;
import adapter.output.presenter.repository.ProjectsInMemoryRepository;


public final class TaskListRunner implements Runnable {
    private static final String QUIT = "quit";
    private final BufferedReader in;
    private final PrintWriter out;

    private final ProjectsInMemoryRepository projectsRepository = new ProjectsInMemoryRepository();

    // Controller
    private final ConsoleHelpController helpController = new ConsoleHelpController(new HelpQuery());
    private final ConsoleShowController showController = new ConsoleShowController(new ShowQuery(projectsRepository));
    private final ConsoleCommandController addController = new ConsoleCommandController(new AddCommand(projectsRepository));
    private final ConsoleCommandController checkController = new ConsoleCommandController(new CheckCommand(projectsRepository));
    private final ConsoleCommandController unCheckController = new ConsoleCommandController(new UnCheckCommand(projectsRepository));
    private final ConsoleCommandController errorController = new ConsoleCommandController(new ErrorCommand());

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
                  String[] commandRest = commandLine.split(" ", 2);
                  switch (commandRest[0]){
                      case "help" -> new ConsoleHelpPresenter(this.out).present(helpController.execute());
                      case "show" -> new ConsoleShowPresenter(this.out).present(showController.execute());
                      case "add" -> this.addController.execute(commandRest[1]);
                      case "check" -> this.checkController.execute(commandRest[1]);
                      case "uncheck" -> this.unCheckController.execute(commandRest[1]);
                      default -> new ConsoleCommandPresenter(this.out).present(this.errorController.execute(commandLine));
                  }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (commandLine.equals(QUIT))
                break;

        }
    }
}
