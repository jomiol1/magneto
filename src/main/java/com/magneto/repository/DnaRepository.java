package com.magneto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.magneto.entity.DnaEntity;

@Repository
public interface DnaRepository extends JpaRepository<DnaEntity,Long>{
	
	public Optional<DnaEntity> findByDna(String dna);
	
	
	@Query("SELECT COUNT(d) FROM DnaEntity d WHERE d.mutant IS :mutant")
	    long countMutantOrPerson(@Param("mutant") Boolean mutant);

}
