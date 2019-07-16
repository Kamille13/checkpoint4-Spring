package com.checkpoint4.checkpoint4.repository;

import com.checkpoint4.checkpoint4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByEmailIgnoreCase(String email);
}
