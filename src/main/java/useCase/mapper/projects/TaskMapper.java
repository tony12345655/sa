package useCase.mapper.projects;

import entity.Task;
import useCase.dto.projects.TaskDto;

import java.util.List;

public class TaskMapper {

    public static TaskDto toDto(Task task){
        TaskDto taskDto = new TaskDto();
        taskDto.Id = task.getId();
        taskDto.description = task.getDescription();
        taskDto.done = task.isDone();
        return taskDto;
    }

    public static List<TaskDto> toDto(List<Task> tasks){
        return tasks.stream().map(TaskMapper::toDto).toList();
    }
}
