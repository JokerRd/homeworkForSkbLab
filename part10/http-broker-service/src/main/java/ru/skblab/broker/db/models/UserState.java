package ru.skblab.broker.db.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class UserState {

    @Id
    @Setter
    @Getter
    private long id;

    @Column(length = 150, nullable = false)
    @Setter
    @Getter
    private String state;

    @Column(nullable = false)
    @Setter
    @Getter
    private LocalDateTime time;

    @Column(length = 200)
    @Setter
    @Getter
    private String message;
}
