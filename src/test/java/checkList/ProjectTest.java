package checkList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProjectTest {
    private static Project project;

    @BeforeClass
    public static void createTask(){
        long Id = 0;
        String name = "sa";
        project = new Project(Id, name);
    }

    @Test
    public void checkProjectId(){
        Assert.assertEquals(0, project.getId());
    }

    @Test
    public void checkProjectDescription(){
        Assert.assertEquals("Is a project", project.getDescription());
    }
}
