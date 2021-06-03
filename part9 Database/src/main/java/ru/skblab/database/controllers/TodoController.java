package ru.skblab.database.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.skblab.database.db.entities.TodoList;
import ru.skblab.database.db.services.TodoListService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TodoController {

    private final TodoListService service;

    public TodoController(TodoListService service) {
        this.service = service;
    }

    @PostMapping("/save")
    @Operation(summary = "Save ToDoList")
    public void save(@Valid @RequestBody TodoList todoList) {
        service.saveTodoList(todoList);
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all TodoLists")
    public List<TodoList> getAllTodoLists(){
        return service.getAllTodoLists();
    }
}
