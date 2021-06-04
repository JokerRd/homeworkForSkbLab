package ru.skblab.broker.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoShort {
    private long id;

    private String name;

    private long phoneNumber;
}
