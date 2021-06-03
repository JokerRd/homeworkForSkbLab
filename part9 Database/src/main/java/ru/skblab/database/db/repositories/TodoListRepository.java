package ru.skblab.database.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skblab.database.db.entities.TodoList;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {

}
