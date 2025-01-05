package com.lld.splitwise.repositories;

import com.lld.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
   public Optional<User> findById(Long id);
}
