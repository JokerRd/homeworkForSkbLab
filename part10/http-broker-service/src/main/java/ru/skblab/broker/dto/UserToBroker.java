package ru.skblab.broker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserToBroker {
    private long id;

    private String name;

    private long phoneNumber;
}
