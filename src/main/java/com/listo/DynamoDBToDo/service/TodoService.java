package com.listo.DynamoDBToDo.service;

import com.listo.DynamoDBToDo.model.Todo;
import java.util.List;

public interface TodoService {

    List<Todo> getAllTodos();         // Retrieve all ToDo items
    Todo saveTodo(Todo todo);         // Add or update a ToDo item
    Todo getTodoById(String id);      // Get a specific ToDo item by ID
    void deleteTodo(String id);       // Delete a ToDo item by ID
    void markTodoAsCompleted(String id); // Mark a ToDo item as completed
}