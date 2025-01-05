package com.lld.splitwise.repositories;

import com.lld.splitwise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface groupRepository extends JpaRepository<Group, Long> {
    public Optional<Group> findById(Long id);
}
