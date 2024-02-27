package CheckList.Iterator;

import CheckList.*;

public interface Iterator {
    void first();
    CheckList currentItem();
    void next();
    boolean isDone();

}
