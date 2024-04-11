package com.example.taskHome;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.taskHome.model.Task;
import com.example.taskHome.repositor.TaskRepository;
import com.example.taskHome.service.TaskService;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static com.example.taskHome.model.TaskStatus.IN_PROGRESS;
import static com.example.taskHome.model.TaskStatus.NOT_STARTED;


@ExtendWith(MockitoExtension.class)
public class TaskServiceSimpleTest {
    @Mock
    public TaskRepository taskRepository;

    @InjectMocks
    public TaskService taskService;

    @Test
    public void updateTaskTest() {

        Task task1 = new Task();
        task1.setId(1L);
        task1.setStatus(NOT_STARTED);

        Task task2 = new Task();
        task2.setId(2L);
        task2.setStatus(IN_PROGRESS);

        given(taskRepository.findById(task1.getId())).willReturn(Optional.of(task1));

        taskService.updateTaskStatus(2L, task2);

        verify(taskRepository).findById(2L);
        verify(taskRepository).save(task1);
    }
}
