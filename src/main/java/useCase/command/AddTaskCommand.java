package useCase.command;

import entity.Project;
import entity.ProjectName;
import useCase.port.input.CommandInput;
import useCase.port.output.CommandOutput;
import useCase.repository.ProjectsRepository;

public class AddTaskCommand implements Command{
    private final ProjectsRepository projectsRepository;
    public AddTaskCommand(ProjectsRepository projectsRepository){
        this.projectsRepository = projectsRepository;
    }
    @Override
    public CommandOutput execute(CommandInput commandInput) {
        String[] commandRestSecond = commandInput.commandLine.split(" ", 2);
        Project project = this.projectsRepository.getProject(ProjectName.of(commandRestSecond[0]));
        if (project == null) {
            return new CommandOutput(String.format("Could not find a project with the name \"%s\".", commandRestSecond[0]) + '\n');
        }
        this.projectsRepository.addTaskToProject(project.getName(), commandRestSecond[1]);
        return new CommandOutput("success");
    }
}
