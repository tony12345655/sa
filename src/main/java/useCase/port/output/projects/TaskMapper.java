package useCase.port.output.projects;

import entity.Task;
import useCase.port.output.projects.dto.TaskDto;
import useCase.port.output.projects.po.TaskPo;

import java.util.List;
import java.util.stream.Collectors;

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
    public static TaskPo toPo(Task task){
        return new TaskPo(task.getId(), task.getDescription(), task.isDone());
    }

    public static List<TaskPo> toPo(List<Task> tasks){
        return tasks.stream().map(TaskMapper::toPo).collect(Collectors.toList());
    }

    public static Task toDomain(TaskPo taskPo){
        return new Task(taskPo.getId(), taskPo.getDescription(), taskPo.isDone());
    }

    public static List<Task> toDomain(List<TaskPo> taskPos){
        return taskPos.stream().map(TaskMapper::toDomain).collect(Collectors.toList());
    }
}
