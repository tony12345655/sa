package CheckList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CheckListFactoryTest {
    private static CheckListFactory checkListFactory;

    @BeforeClass
    public static void createCheckListFactory(){
        checkListFactory = CheckListFactory.getInstance();
    }
    @Test
    public void createTask(){
        String description = "Finish Homework";
        Task task = checkListFactory.createTask(description);
        Assert.assertEquals(description, task.getDescription());
    }
    @Test
    public void checkProject(){
        String name = "sa";
        Project project = checkListFactory.createProject(name);
        Assert.assertEquals("Is a project", project.getDescription());
    }

}
