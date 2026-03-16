package com.example.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> all() {
        return repo.findAll();
    }

    public Task get(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Task id must not be null");
        }
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found"));
    }

    public Task create(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task must not be null");
        }
        return repo.save(task);
    }

    public Task update(Long id, Task updated) {
        if (id == null) {
            throw new IllegalArgumentException("Task id must not be null");
        }

        Task existing = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found"));

        existing.setTitle(updated.getTitle());
        existing.setCompleted(updated.isCompleted());

        return repo.save(existing);
    }

    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Task id must not be null");
        }
        repo.deleteById(id);
    }

}
