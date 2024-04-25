package useCase.command;

import entity.Projects;
import useCase.port.input.CommandInput;
import useCase.port.output.command.CommandOutput;
import adapter.output.presenter.repository.ProjectsInMemoryRepository;

public class UnCheckCommand implements Command{
    private final ProjectsInMemoryRepository projectsRepository;

    public UnCheckCommand(ProjectsInMemoryRepository projectsRepository){
        this.projectsRepository = projectsRepository;
    }
    @Override
    public CommandOutput execute(CommandInput commandInput) {
        long taskId = Long.parseLong(commandInput.commandLine);
        Projects projects = this.projectsRepository.getProjects();
        projects.setTaskDone(taskId, false);
        this.projectsRepository.save(projects);
        return new CommandOutput("success");
    }
}
