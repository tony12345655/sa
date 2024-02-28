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
    private final LinkedHashMap<String, Command> commands = new LinkedHashMap<String, Command>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskList(in, out).run();
    }

    public TaskList(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
        LinkedHashMap<String, Project> projects = new LinkedHashMap<>();
        commands.put("show", new ShowCommand(projects));
        commands.put("help", new HelpCommand());
        commands.put("add", new AddCommand(projects));
        commands.put("check", new CheckCommand(projects));
        commands.put("uncheck", new unCheckCommand(projects));
    }

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
        if (this.commands.get(instruction) == null)
            command = new ErrorCommand(instruction);
        else
            command = this.commands.get(instruction);

        if (commandRest.length == 1)
            command.execute(null);
        else
            command.execute(commandRest[1]);
    }
}
