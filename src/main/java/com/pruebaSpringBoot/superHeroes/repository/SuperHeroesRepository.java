package com.pruebaSpringBoot.superHeroes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pruebaSpringBoot.superHeroes.entity.SuperHeroe;

@Repository
public interface SuperHeroesRepository extends CrudRepository<SuperHeroe, Long>{

	List<SuperHeroe>findAll();
	
	Optional<SuperHeroe> findById(Long id);
	
	void deleteById(Long id);
	
	List<SuperHeroe> findByNameLike(String name);
	
	SuperHeroe save(SuperHeroe superHeroe);
}
