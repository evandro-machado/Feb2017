package com.evandro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.evandro.model.Operator;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer>{

	@Query(value="select o from Operator o where o.name = :pname")
	public Operator findByName(@Param("pname") String name);
}
