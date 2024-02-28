package checkList.Iterator;

import checkList.CheckList;
import checkList.CheckListFactory;
import checkList.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ListIteratorTest {
    private static Project project;
    @BeforeClass
    public static void createNullIterator(){
        project = CheckListFactory.getInstance().createProject("sa");
        Task task1  = CheckListFactory.getInstance().createTask("hw1");
        Task task2 = CheckListFactory.getInstance().createTask("hw2");
        project.add(task1);
        project.add(task2);
    }
    @Test
    public void firstTest(){
        Iterator it = project.createIterator();
        CheckList task = it.currentItem();
        Assert.assertEquals("hw1", task.getDescription());
    }

    @Test
    public void currentItemTest(){
        Iterator it = project.createIterator();
        CheckList task = it.currentItem();
        Assert.assertEquals("hw1", task.getDescription());
    }

    @Test
    public void nestTest(){
        Iterator it = project.createIterator();
        it.next();
        CheckList task = it.currentItem();
        Assert.assertEquals("hw2", task.getDescription());
    }

    @Test
    public void isDoneTest(){
        Iterator it = project.createIterator();
        it.next();
        Assert.assertFalse(it.isDone());
        it.next();
        Assert.assertTrue(it.isDone());
    }
}
