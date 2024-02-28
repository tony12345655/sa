package checkList;

import checkList.Iterator.Iterator;

public interface CheckList {
    void add(CheckList checkList);
    void check();
    void unCheck();
    boolean isDone();
    long getId();
    String getDescription();
    void show();

    Iterator createIterator();

}
