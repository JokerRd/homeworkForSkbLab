package ru.skblab.nohttpbrokerservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoShort {
    private long id;

    private String name;

    private String phoneNumber;
}
