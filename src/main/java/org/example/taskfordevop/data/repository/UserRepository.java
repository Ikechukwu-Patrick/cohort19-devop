package org.example.taskfordevop.data.repository;

import org.example.taskfordevop.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
}
