package com.evandro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evandro.model.State;

public interface StateRepository extends JpaRepository<State, Integer> {

}
