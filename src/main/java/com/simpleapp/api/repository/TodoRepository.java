package com.simpleapp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleapp.api.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
