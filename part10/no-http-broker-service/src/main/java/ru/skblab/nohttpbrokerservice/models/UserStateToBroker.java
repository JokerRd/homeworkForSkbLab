package ru.skblab.nohttpbrokerservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserStateToBroker {
    private long id;
    private String state;
    private LocalDateTime time;
    private String message;
}
