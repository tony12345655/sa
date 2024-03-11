package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

import IO.IO;
import IO.Shell;
import adapter.CommandAdapter;
import project.Project;


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
            this.io.Flush();
            String command;
            try {
                command = this.io.input();
                CommandAdapter commandAdapter = new CommandAdapter(this.projects, command);
                commandAdapter.run(this.io);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT))
                break;

        }
    }
}
