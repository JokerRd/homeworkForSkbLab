package ru.skblab.broker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserState {
    private long id;
    private String state;
    private LocalDateTime time;

    @JsonIgnore
    private String message;
}
