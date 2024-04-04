package useCase.command;


public abstract class Command {
    private final CommandName name;
    public Command(CommandName name){
        this.name = name;
    }
    public CommandName getCommandName(){
        return this.name;
    }
    public abstract String execute(String commandLine);
}
