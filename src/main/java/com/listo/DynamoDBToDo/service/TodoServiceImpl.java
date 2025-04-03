package com.listo.DynamoDBToDo.service;

import com.listo.DynamoDBToDo.model.Todo;
import com.listo.DynamoDBToDo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getAllTodos() {
        Iterable<Todo> todos = todoRepository.findAll();
        System.out.println("todos: " + todos);
        List<Todo> todoList = new ArrayList<>();
        todos.forEach(todoList::add);
        return todoList;
    }

    @Override
    public Todo saveTodo(Todo todo) {
//        if (todo.getCreatedAt() == null) {
//            todo.setCreatedAt(LocalDateTime.now());
//        }
//        todo.setUpdatedAt(LocalDateTime.now());
        return todoRepository.save(todo);
    }

    @Override
    public Todo getTodoById(String id) {
        Optional<Todo> todo = todoRepository.findById(id);
        return todo.orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));
    }

    @Override
    public void deleteTodo(String id) {
        todoRepository.deleteById(id);
    }

    @Override
    public void markTodoAsCompleted(String id) {
        Todo todo = getTodoById(id);
        todo.setCompleted(true);
        todoRepository.save(todo);
    }
}