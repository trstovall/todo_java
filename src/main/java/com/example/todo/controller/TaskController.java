package com.example.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.dto.TaskPatchRequest;
import com.example.todo.model.Task;
import com.example.todo.service.TaskService;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> list() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Task get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return service.create(task);
    }

    @PutMapping("/{id}")
    public Task update(
            @PathVariable Long id,
            @RequestBody Task task) {

        return service.update(id, task);
    }

    @PatchMapping("/{id}")
    public Task patch(
            @PathVariable Long id,
            @RequestBody TaskPatchRequest task) {

        Task existing = service.get(id);

        if (task.getTitle() != null) {
            existing.setTitle(task.getTitle());
        }

        if (task.getCompleted() != null) {
            existing.setCompleted(task.getCompleted());
        }

        return service.update(id, existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}