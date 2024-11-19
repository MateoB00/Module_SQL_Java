package com.exo1.exo1.repository;

import com.exo1.exo1.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u " +
            "LEFT JOIN FETCH u.task t " +
            "LEFT JOIN FETCH u.projets p " +
            "LEFT JOIN FETCH p.tasks " +
            "WHERE u.id = :id")
    Optional<User> findByIdWithAssociations(@Param("id") Long id);

    @Query("SELECT DISTINCT u FROM User u " +
            "LEFT JOIN FETCH u.task t " +
            "LEFT JOIN FETCH u.projets p " +
            "LEFT JOIN FETCH p.tasks")
    List<User> findAllWithAssociations();

    @Query("SELECT DISTINCT u FROM User u " +
            "LEFT JOIN FETCH u.task t " +
            "LEFT JOIN FETCH u.projets p " +
            "LEFT JOIN FETCH p.tasks")
    Page<User> findAllWithAssociationsPagination(Pageable pageable);
}