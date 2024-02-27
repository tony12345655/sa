package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import CheckList.*;
import Command.*;


public final class TaskList implements Runnable {
    private static final String QUIT = "quit";
    private final BufferedReader in;
    private final PrintWriter out;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskList(in, out).run();
    }

    public TaskList(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }

    private final LinkedHashMap<String, Project> projects = new LinkedHashMap<String, Project>();

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String instruction = commandRest[0];
        Command command;
        switch (instruction) {
            case "show":
                command = new ShowCommand(this.projects);
                break;
            case "add":
                command = new AddCommand(this.projects, commandRest[1]);
                break;
            case "check":
                command = new CheckCommand(this.projects, commandRest[1]);
                break;
            case "uncheck":
                command = new unCheckCommand(this.projects, commandRest[1]);
                break;
            case "help":
                command = new HelpCommand();
                break;
            default:
                command = new ErrorCommand(instruction);
                break;
        }
        command.execute();
    }
}
