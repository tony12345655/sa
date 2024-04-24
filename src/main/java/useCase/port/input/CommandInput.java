package useCase.port.input;

public class CommandInput {
    public String nowCommandLine;
    public String nextCommandLine;

    public CommandInput(String commandLine){
        String[] commandRest = commandLine.split(" ", 2);
        this.nowCommandLine = commandRest[0];
        if (commandRest.length != 1)
            this.nextCommandLine = commandRest[1];
        else
            this.nextCommandLine = "";
    }

}
