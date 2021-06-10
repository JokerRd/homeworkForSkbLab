package ru.skblab.broker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserStateResponseDto {
    private long id;

    private String state;

    private LocalDateTime time;
}
