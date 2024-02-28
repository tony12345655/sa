package checkList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class TaskTest {
    private static Task task;

    @BeforeClass
    public static void createTask(){
        String description = "Finish Homework";
        task = CheckListFactory.getInstance().createTask(description);
    }
    @Test
    public void checkTaskDescription(){
        Assert.assertEquals("Finish Homework", task.getDescription());
    }
}
