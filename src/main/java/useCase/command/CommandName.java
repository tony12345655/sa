package useCase.command;

public record CommandName(String value) {
    public static CommandName of(String name){
        return new CommandName(name);
    }
    @Override
    public String toString() {
        return this.value;
    }
}
