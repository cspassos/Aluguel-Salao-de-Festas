package com.salao.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salao.v1.model.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long>{

	@Query("select al from Aluguel al "
			+ "Where al.identifier = :id")
	Aluguel findOne(@Param("id") Long id);

	
}
