package checkList.Iterator;

import checkList.*;

public interface Iterator {
    void first();
    CheckList currentItem();
    void next();
    boolean isDone();

}
