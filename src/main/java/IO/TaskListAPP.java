package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import adapter.input.controller.console.*;
import adapter.output.presenter.console.ConsoleCommandPresenter;
import adapter.output.presenter.console.ConsoleHelpPresenter;
import adapter.output.presenter.console.ConsoleShowPresenter;
import adapter.output.repository.ProjectsInMemoryRepositoryPeer;
import entity.Projects;
import useCase.service.*;
import adapter.output.repository.ProjectsInMemoryRepository;


public final class TaskListAPP implements Runnable {
    private static final String QUIT = "quit";
    private final BufferedReader in;
    private final PrintWriter out;

    private final ConsoleControllerExecutor consoleControllerExecutor;

    public static void main(String[] args){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskListAPP(in, out).run();
    }

    public TaskListAPP(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
        ProjectsInMemoryRepository projectsInMemoryRepository = new ProjectsInMemoryRepository(new ProjectsInMemoryRepositoryPeer());
        projectsInMemoryRepository.save(new Projects());
        this.consoleControllerExecutor = new ConsoleControllerExecutor();
        consoleControllerExecutor.register(ProjectsCommands.ADD, new AddConsoleController(new AddService(projectsInMemoryRepository)));
        consoleControllerExecutor.register(ProjectsCommands.CHECK, new CheckConsoleController(new CheckService(projectsInMemoryRepository)));
        consoleControllerExecutor.register(ProjectsCommands.UNCHECK, new UnCheckConsoleController(new UnCheckService(projectsInMemoryRepository)));
        consoleControllerExecutor.register(ProjectsCommands.ERROR, new ErrorConsoleController(new ErrorService(), new ConsoleCommandPresenter(out)));
        consoleControllerExecutor.register(ProjectsCommands.HELP, new HelpConsoleController(new HelpService(), new ConsoleHelpPresenter(out)));
        consoleControllerExecutor.register(ProjectsCommands.SHOW, new ConsoleShowController(new ShowService(projectsInMemoryRepository), new ConsoleShowPresenter(out)));

    }

    public void run() {
        while (true) {
            this.out.print("> ");
            this.out.flush();
            String commandLine;
            try {
                  commandLine = this.in.readLine();
                  this.consoleControllerExecutor.execute(commandLine);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (commandLine.equals(QUIT))
                break;

        }
    }
}
