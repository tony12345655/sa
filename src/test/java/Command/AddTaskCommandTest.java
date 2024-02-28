package Command;

import CheckList.*;
import CheckList.Iterator.Iterator;
import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedHashMap;

public class AddTaskCommandTest{
    @Test
    public void checkAddTask(){
        Project project1 = CheckListFactory.getInstance().createProject("sa");
        Project project2 = CheckListFactory.getInstance().createProject("posd");
        LinkedHashMap<String, Project> projects = new LinkedHashMap<>();
        projects.put("sa", project1);
        projects.put("posd", project2);
        String commandLine1 = "sa hw1";
        String commandLine2 = "posd hw2";
        Command command = new AddTaskCommand(projects);
        command.execute(commandLine1);
        command.execute(commandLine2);
        Iterator project1_it = project1.createIterator();
        Iterator project2_it = project2.createIterator();
        Assert.assertEquals("hw1", project1_it.currentItem().getDescription());
        Assert.assertEquals("hw2",project2_it.currentItem().getDescription());
    }
}
