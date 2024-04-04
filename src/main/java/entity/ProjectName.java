package entity;

public record ProjectName(String value) {
    public static ProjectName of(String name){
        return new ProjectName(name);
    }
    @Override
    public String toString() {
        return this.value;
    }
}
