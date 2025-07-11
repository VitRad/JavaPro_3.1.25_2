package ru.rad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rad.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
