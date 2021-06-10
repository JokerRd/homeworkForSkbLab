package ru.skblab.configandevents.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Duration;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigUserModel {

    private String subconfig;

    private String user;

    private Duration ttl;
}
