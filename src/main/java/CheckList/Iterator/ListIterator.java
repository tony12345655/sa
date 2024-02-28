package CheckList.Iterator;

import CheckList.*;

import java.util.ArrayList;

public class ListIterator implements Iterator{
    private final ArrayList<CheckList> checkLists;
    private int now = 0;
    public ListIterator(ArrayList<CheckList> checkLists){
        this.checkLists = checkLists;
        first();
    }
    @Override
    public void first() {
        this.now = 0;
    }

    @Override
    public CheckList currentItem() {
        return this.checkLists.get(this.now);
    }

    @Override
    public void next() {
        this.now++;
    }

    @Override
    public boolean isDone() {
        return this.now == this.checkLists.size();
    }
}
