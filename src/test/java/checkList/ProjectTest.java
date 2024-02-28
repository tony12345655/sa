package checkList;

import com.codurance.training.tasks.TaskList;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProjectTest {
    private static Project project;

    @BeforeClass
    public static void createTask(){
        String name = "sa";
        project = CheckListFactory.getInstance().createProject(name);
    }
    @Test
    public void checkProjectDescription(){
        Assert.assertEquals("Is a project", project.getDescription());
    }
}
