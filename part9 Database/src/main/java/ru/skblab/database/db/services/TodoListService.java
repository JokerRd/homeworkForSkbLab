package ru.skblab.database.db.services;

import org.springframework.stereotype.Service;
import ru.skblab.database.db.entities.TodoList;
import ru.skblab.database.db.repositories.TodoListRepository;

import java.util.List;

@Service
public class TodoListService {

    private final TodoListRepository repository;

    public TodoListService(TodoListRepository repository) {
        this.repository = repository;
    }

    public void saveTodoList(TodoList todoList){
        repository.save(todoList);
    }

    public List<TodoList> getAllTodoLists(){
        return repository.findAll();
    }
}
