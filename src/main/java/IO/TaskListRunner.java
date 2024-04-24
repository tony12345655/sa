package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import adapter.controller.CommandController;
import adapter.controller.HelpController;
import adapter.controller.ShowController;
import adapter.presenter.console.ConsoleCommandPresenter;
import adapter.presenter.console.ConsoleHelpPresenter;
import adapter.presenter.console.ConsoleShowPresenter;
import useCase.command.*;
import useCase.query.HelpQuery;
import useCase.query.ShowQuery;
import useCase.repository.ProjectsRepository;


public final class TaskListRunner implements Runnable {
    private static final String QUIT = "quit";
    private final BufferedReader in;
    private final PrintWriter out;

    private final ProjectsRepository projectsRepository = new ProjectsRepository();

    // Controller
    private final HelpController helpController = new HelpController(new HelpQuery());
    private final ShowController showController = new ShowController(new ShowQuery(projectsRepository));
    private final CommandController addController = new CommandController(new AddCommand(projectsRepository));
    private final CommandController checkController = new CommandController(new CheckCommand(projectsRepository));
    private final CommandController unCheckController = new CommandController(new UnCheckCommand(projectsRepository));
    private final CommandController errorController = new CommandController(new ErrorCommand());

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
