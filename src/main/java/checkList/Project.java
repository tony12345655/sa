package checkList;
import checkList.Iterator.Iterator;
import checkList.Iterator.ListIterator;
import com.codurance.training.tasks.TaskList;
import output.Out;

import java.util.ArrayList;

public class Project implements CheckList{
    private final long Id;
    private final String name;
    private final ArrayList<CheckList> tasks = new ArrayList<>();

    public Project(long Id, String name){
        this.Id = Id;
        this.name = name;
    }
    @Override
    public void add(CheckList checkList) {
        this.tasks.add(checkList);
    }

    @Override
    public void check() {
        for (CheckList task : this.tasks)
            task.check();
    }

    @Override
    public void unCheck() {
        for (CheckList task : this.tasks)
            task.unCheck();
    }

    @Override
    public boolean isDone() {
        boolean done = true;
        for (CheckList task : this.tasks){
            if (!task.isDone()) {
                done = false;
                break;
            }
        }
        return done;
    }

    @Override
    public long getId() {
        return this.Id;
    }

    @Override
    public String getDescription() {
        return "Is a project";
    }

    @Override
    public void show() {
        Out.getInstance().println(this.name);
        for (CheckList task : this.tasks)
            task.show();
        Out.getInstance().println();
    }

    @Override
    public Iterator createIterator() {
        return new ListIterator(this.tasks);
    }
}
