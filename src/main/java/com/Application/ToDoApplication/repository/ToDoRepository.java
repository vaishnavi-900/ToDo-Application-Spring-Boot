package com.Application.ToDoApplication.repository;

import com.Application.ToDoApplication.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Todo, Integer> {
}
