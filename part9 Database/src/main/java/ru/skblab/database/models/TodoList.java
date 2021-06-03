package ru.skblab.database.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TodoList {

    private String name;

    private List<String> events;
}
