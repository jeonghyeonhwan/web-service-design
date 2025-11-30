package com.example.web_service.service;

import com.example.web_service.model.Todo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {

    private final Map<Long, Todo> todos = new HashMap<>();
    private Long seq = 1L;

    public Todo create(String title) {
        Todo t = new Todo(seq++, title);
        todos.put(t.getId(), t);
        return t;
    }

    public Todo get(Long id) {
        return todos.get(id);
    }

    public List<Todo> getAll() {
        return new ArrayList<>(todos.values());
    }

    public Todo update(Long id, String title) {
        Todo t = todos.get(id);
        if (t == null) return null;
        t.setCompleted(!t.isCompleted());
        return t;
    }

    public boolean delete(Long id) {
        return todos.remove(id) != null;
    }
}
