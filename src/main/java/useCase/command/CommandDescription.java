package useCase.command;

public class CommandDescription {
    private final String commandName;

    public CommandDescription(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName() {
        return this.commandName;
    }

    public boolean equals(CommandDescription commandDescription) {
        return this.commandName.equals(commandDescription.getCommandName());
    }
}
