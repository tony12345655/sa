package adapter;

import IO.IO;
import application.CommandApplication;
import command.Command;
import project.Project;

import java.util.LinkedHashMap;

public class CommandAdapter {
    private final LinkedHashMap<String, Project> projects;
    private final String nowCommandLine;
    private final String nextCommandLine;

    public CommandAdapter(LinkedHashMap<String, Project> projects, String commandLine){
        this.projects = projects;
        String[] commandRest = commandLine.split(" ", 2);
        this.nowCommandLine = commandRest[0];
        if (commandRest.length == 1)
            this.nextCommandLine = null;
        else
            this.nextCommandLine  = commandRest[1];
    }
    public void run(IO io) {
        Command command;
        if (CommandApplication.getInstance().CreateCommand(this.nowCommandLine) != null)
            command = CommandApplication.getInstance().CreateCommand(this.nowCommandLine);
        else
            command = CommandApplication.getInstance().CreateCommand("error");
        String result = command.execute(this.projects, this.nowCommandLine, this.nextCommandLine);
        io.Output(result);
    }
}
