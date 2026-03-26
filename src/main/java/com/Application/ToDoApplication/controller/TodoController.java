package com.Application.ToDoApplication.controller;


import com.Application.ToDoApplication.model.Todo;
import com.Application.ToDoApplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   //HTTP requests and Automatically returns JSON
@RequestMapping("/todos")
@CrossOrigin


public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping
    public Todo addTask(@RequestBody Todo todo) {
        return service.addTask(todo);
    }

    @GetMapping
    public List<Todo> getAllTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Todo getTask(@PathVariable int id) {
        return service.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        service.deleteTask(id);
        return "Task deleted";
    }

    @PutMapping("/{id}")
    public Todo updateTask(@PathVariable int id, @RequestBody Todo todo) {
        return service.updateTask(id, todo);
    }
}
