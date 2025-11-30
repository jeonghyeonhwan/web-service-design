package com.example.web_service.model;

public class Todo {
    private Long id;
    private String title;
    private boolean completed;

    public Todo(Long id, String title) {
        this.id = id;
        this.title = title;
        this.completed = false;
    }

    // getters/setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
