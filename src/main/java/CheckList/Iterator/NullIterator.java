package CheckList.Iterator;

import CheckList.*;

public class NullIterator implements Iterator{

    private final Task task;
    public NullIterator(Task task){
        this.task = task;
    }

    @Override
    public void first() {

    }

    @Override
    public CheckList currentItem() {
        return this.task;
    }

    @Override
    public void next() {
        throw new Error("Not next!");
    }

    @Override
    public boolean isDone() {
        return false;
    }
}
