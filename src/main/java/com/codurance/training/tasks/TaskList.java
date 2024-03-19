package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

import IO.IO;
import IO.Shell;
import adapter.controller.commandController.CommandController;
import adapter.controller.commandController.CommandControllers;
import adapter.presenter.CommandPresenter;
import entity.Project;
import useCase.command.Command;


public final class TaskList implements Runnable {
    private static final String QUIT = "quit";
    private final IO io;
    private final LinkedHashMap<String, Project> projects = new LinkedHashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskList(in, out).run();
    }

    public TaskList(BufferedReader reader, PrintWriter writer) {
        this.io = new Shell(reader, writer);
    }

    public void run() {
        while (true) {
            this.io.output("> ");
            this.io.flush();
            String commandLine;
            try {
                commandLine = this.io.input();
                String[] commandRest = commandLine.split(" ", 2);
                CommandController controller = CommandControllers.getInstance().getCommandController(commandRest[0]);
                Command command = controller.createCommand(commandLine);
                CommandPresenter commandPresenter = new CommandPresenter();
                commandPresenter.execute(command, this.io);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (commandLine.equals(QUIT))
                break;

        }
    }
}
