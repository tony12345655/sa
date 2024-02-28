package CheckList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class TaskTest {
    private static Task task;

    @BeforeClass
    public static void createTask(){
        long Id = 1;
        String description = "Finish Homework";
        task = new Task(Id, description);
    }

    @Test
    public void checkTaskId(){
        Assert.assertEquals(1, task.getId());
    }

    @Test
    public void checkTaskDescription(){
        Assert.assertEquals("Finish Homework", task.getDescription());
    }
}
