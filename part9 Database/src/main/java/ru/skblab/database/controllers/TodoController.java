package ru.skblab.database.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.skblab.database.db.entities.TodoList;
import ru.skblab.database.db.services.TodoListService;
import ru.skblab.database.dto.TodoListRequestDto;
import ru.skblab.database.dto.TodoListResponseDto;
import ru.skblab.database.dto.services.TodoMapper;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TodoController {

    private final TodoListService service;

    private final TodoMapper mapper;

    public TodoController(TodoListService service, TodoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/save")
    @Operation(summary = "Save ToDoList")
    public void save(@Valid @RequestBody TodoListRequestDto todoList) {
        service.saveTodoList(mapper.TodoListRequestToEntity(todoList));
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all TodoLists")
    public List<TodoListResponseDto> getAllTodoLists(){
        return service.getAllTodoLists().stream()
                .map(mapper::TodoListEntityToResponse)
                .collect(Collectors.toList());
    }
}
