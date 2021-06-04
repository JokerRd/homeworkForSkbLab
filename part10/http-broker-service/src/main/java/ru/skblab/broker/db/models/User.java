package ru.skblab.broker.db.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    @JsonIgnore
    @Setter
    @Getter
    private long id;

    @Setter
    @Getter
    @Column(length = 150, nullable = false)
    private String name;

    @Setter
    @Getter
    @Column(length = 100, nullable = false)
    private String login;

    @Setter
    @Getter
    @Column(length = 50, nullable = false)
    private String password;

    @Setter
    @Getter
    @Column
    private Long phoneNumber;

}
