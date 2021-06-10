package ru.skblab.database.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoListRequestDto {

    @NotBlank(message = "Name not filled")
    private String name;

    @NotNull(message = "Events is null")
    @NotEmpty(message = "Events not filled")
    private List<String> events;
}
