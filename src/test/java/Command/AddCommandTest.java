package Command;

import CheckList.Iterator.Iterator;
import CheckList.Project;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;

public class AddCommandTest {
    @Test
    public void checkAddCommandAddProject(){
        LinkedHashMap<String, Project> projects = new LinkedHashMap<>();
        String commandLine = "project sa";
        Command command = new AddCommand(projects);
        command.execute(commandLine);
        Assert.assertEquals("Is a project", projects.get("sa").getDescription());
    }
    @Test
    public void  checkAddCommandAddTask(){
        LinkedHashMap<String, Project> projects = new LinkedHashMap<>();
        String commandLine1 = "project sa";
        Command command = new AddCommand(projects);
        command.execute(commandLine1);
        String commandLine2 = "task sa hw1";
        command.execute(commandLine2);
        Project project = projects.get("sa");
        Iterator it = project.createIterator();
        Assert.assertEquals("hw1", it.currentItem().getDescription());
    }
}
