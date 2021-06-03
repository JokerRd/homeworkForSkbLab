package ru.skblab.database.db.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class TodoList {

    @Id
    @GeneratedValue
    @JsonIgnore
    @Setter
    @Getter
    private Long id;

    @Column(length = 100, nullable = false)
    @Setter
    @Getter
    @NotBlank(message = "Name not filled")
    private String name;

    @ElementCollection
    @Setter
    @Getter
    @NotNull(message = "Events is null")
    @NotEmpty(message = "Events not filled")
    private List<String> events;
}
