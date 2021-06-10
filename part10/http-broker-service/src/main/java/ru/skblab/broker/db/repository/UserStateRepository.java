package ru.skblab.broker.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skblab.broker.db.models.UserState;

public interface UserStateRepository extends JpaRepository<UserState, Long> {

}
