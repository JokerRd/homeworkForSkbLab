package ru.skblab.broker.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skblab.broker.db.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
