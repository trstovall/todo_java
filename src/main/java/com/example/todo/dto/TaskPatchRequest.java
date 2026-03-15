package com.example.todo.dto;

public class TaskPatchRequest {

    private String title;
    private Boolean completed;

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }

}