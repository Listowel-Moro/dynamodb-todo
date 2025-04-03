package com.listo.DynamoDBToDo.controller;

import com.listo.DynamoDBToDo.model.Todo;
import com.listo.DynamoDBToDo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // Display all ToDo items
    @GetMapping
    public String listTodos(Model model) {
        List<Todo> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        model.addAttribute("newTodo", new Todo()); // For the add form
        return "index"; // Renders todos.html
    }

    // Add a new ToDo item
    @PostMapping("/add")
    public String addTodo(@ModelAttribute("newTodo") Todo todo) {
        todoService.saveTodo(todo);
        return "redirect:/"; // Redirect to the list page
    }

    // Mark a ToDo as completed
    @PostMapping("/complete/{id}")
    public String completeTodo(@PathVariable String id) {
        todoService.markTodoAsCompleted(id);
        return "redirect:/";
    }

    // Delete a ToDo item
    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);
        return "redirect:/";
    }
}