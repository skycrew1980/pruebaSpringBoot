package com.pruebaSpringBoot.superHeroes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pruebaSpringBoot.superHeroes.entity.SuperHeroe;

@Repository
public interface SuperHeroesRepository extends CrudRepository<SuperHeroe, Integer>{

	List<SuperHeroe>findAll();
	
	SuperHeroe findById(Long id);
	
	void deleteById(Long id);
	
	List<SuperHeroe> findByNameLike(String name);
	
	SuperHeroe save(SuperHeroe superHeroe);
	
//	List<SuperHeroe> findByFirstnameContaining(String name);
}
