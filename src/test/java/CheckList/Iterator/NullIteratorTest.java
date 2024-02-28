package CheckList.Iterator;

import CheckList.CheckList;
import CheckList.CheckListFactory;
import CheckList.Task;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class NullIteratorTest {
    private static Iterator nullIterator;
    @BeforeClass
    public static void createNullIterator(){
        Task task = CheckListFactory.getInstance().createTask("homework 1");
        nullIterator = task.createIterator();
    }

    @Test
    public void currentItemTest(){
        CheckList task = nullIterator.currentItem();
        Assert.assertEquals("homework 1", task.getDescription());
    }

    @Test
    public void isDoneTest(){
        Assert.assertTrue(nullIterator.isDone());
    }
}
