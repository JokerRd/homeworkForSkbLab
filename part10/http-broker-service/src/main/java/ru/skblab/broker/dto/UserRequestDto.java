package ru.skblab.broker.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private String name;

    private String login;

    private String password;

    private Long phoneNumber;
}
