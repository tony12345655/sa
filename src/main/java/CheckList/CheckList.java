package CheckList;

public interface CheckList {
    void add(CheckList checkList);
    void check();
    void unCheck();
    boolean isDone();
    long getId();
    String getDescription();

}
