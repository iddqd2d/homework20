package com.spring.springmvc.repository;

import com.spring.springmvc.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query(value = "SELECT p FROM Project p WHERE p.balance > :balance")
    List<Project> findAllMoreThanBalance(@Param("balance") Integer balance);
}
