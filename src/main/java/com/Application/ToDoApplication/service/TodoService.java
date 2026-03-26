package com.Application.ToDoApplication.service;

import com.Application.ToDoApplication.model.Todo;
import com.Application.ToDoApplication.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
It connects Controller ↔ Repository
Controller = receives request
Service = processes logic
Repository = talks to database*/

@Service
public class TodoService {

    @Autowired
    private ToDoRepository repo;
    public Todo addTask(Todo todo) {
        return repo.save(todo);
    }

    public List<Todo> getAllTasks() {
        return repo.findAll();
    }

    public Todo getTaskById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteTask(int id) {
        repo.deleteById(id);
    }

    public Todo updateTask(int id, Todo updatedTodo) {

        Todo existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setTitle(updatedTodo.getTitle());
            existing.setDescription(updatedTodo.getDescription());
            existing.setCompleted(updatedTodo.isCompleted());

            return repo.save(existing);
        }

        return null;
    }



}
