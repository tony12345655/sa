package Command;

import CheckList.Project;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;

public class AddProjectCommandTest {
    @Test
    public void checkAddProject(){
        LinkedHashMap<String, Project> projects = new LinkedHashMap<>();
        String commandLine = "sa";
        Command command = new AddProjectCommand(projects);
        command.execute(commandLine);
        Project project = projects.get("sa");
        Assert.assertEquals("Is a project", project.getDescription());
    }
}
