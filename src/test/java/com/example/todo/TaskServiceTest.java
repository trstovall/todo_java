package com.example.todo;

import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;
import com.example.todo.service.TaskService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @Test
    void shouldReturnTask() {

        TaskRepository repo = Mockito.mock(TaskRepository.class);

        Task task = new Task("write tests");

        Mockito.when(repo.findById(1L))
            .thenReturn(Optional.of(task));

        TaskService service = new TaskService(repo);

        Task result = service.get(1L);

        assertEquals("write tests", result.getTitle());

    }

}