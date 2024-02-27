package com.codurance.training.tasks;

import CheckList.*;
import CheckList.Iterator.Iterator;
import Command.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;


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
        String command = commandRest[0];
        switch (command) {
            case "show":
                show();
                break;
            case "add":
                add(commandRest[1]);
                break;
            case "check":
                check(commandRest[1]);
                break;
            case "uncheck":
                uncheck(commandRest[1]);
                break;
            case "help":
                help();
                break;
            default:
                error(command);
                break;
        }
    }

    private void show() {
       Command command = new ShowCommand(this.projects);
        command.execute();
    }

    private void add(String commandLine) {
       Command command = new AddCommand(this.projects, commandLine);
       command.execute();
    }

    private void check(String idString) {
        Command command = new CheckCommand(this.projects, idString);
        command.execute();
    }

    private void uncheck(String idString) {
        Command command = new unCheckCommand(this.projects, idString);
        command.execute();
    }


    private void help() {
        Command command = new HelpCommand();
        command.execute();
    }

    private void error(String unKnowCommand) {
        Command command = new ErrorCommand(unKnowCommand);
        command.execute();
    }
}
