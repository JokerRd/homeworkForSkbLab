package ru.skblab.database.dto.services;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.skblab.database.db.entities.TodoList;
import ru.skblab.database.dto.TodoListRequestDto;
import ru.skblab.database.dto.TodoListResponseDto;

@Mapper(componentModel = "spring")
public interface TodoMapper {


    TodoList TodoListRequestToEntity(TodoListRequestDto requestDto);

    TodoListResponseDto TodoListEntityToResponse(TodoList entity);
}
