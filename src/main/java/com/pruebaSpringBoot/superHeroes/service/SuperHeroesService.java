package com.pruebaSpringBoot.superHeroes.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.pruebaSpringBoot.superHeroes.entity.SuperHeroe;
import com.pruebaSpringBoot.superHeroes.mapping.SuperHeroeMapping;
import com.pruebaSpringBoot.superHeroes.model.SuperHeroeDTO;
import com.pruebaSpringBoot.superHeroes.repository.SuperHeroesRepository;

import javassist.NotFoundException;

@Service
public class SuperHeroesService {
	
	static final Logger log = LoggerFactory.getLogger(SuperHeroesService.class.getName());
	
	@Autowired
    private SuperHeroesRepository superHeroesRepository;
 
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true, timeout = -1, rollbackFor = Exception.class)
	public List<SuperHeroeDTO> findAll() {
		
		return SuperHeroeMapping.mappingToListSuperHeroeDTO(superHeroesRepository.findAll());
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true, timeout = -1, rollbackFor = Exception.class)
	public SuperHeroeDTO findById(Long id) {
		
		return SuperHeroeMapping.mappingToSuperHeroeDTO(superHeroesRepository.findById(id).get());
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true, timeout = -1, rollbackFor = Exception.class)
	public List<SuperHeroeDTO> findByName(String name) {
		
		return SuperHeroeMapping.mappingToListSuperHeroeDTO(superHeroesRepository.findByNameLike(name));
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false, timeout = -1, rollbackFor = Exception.class)
	public void delete(Long id) throws NotFoundException {
		
		log.debug("delete(Long id) - start");

	    Assert.notNull(id, "SuperHeroe id no puede ser null para eliminar un SuperHeroe");
	    if (superHeroesRepository.findById(id) == null) {
	      throw new NotFoundException("No existe el super héroe con ese id");
	    }
	    superHeroesRepository.deleteById(id);
	    log.debug("delete(Long id) - end");
		
	}  
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false, timeout = -1, rollbackFor = Exception.class)
	public SuperHeroe update(SuperHeroe superHeroe) throws NotFoundException {
		
		 log.debug("update(SuperHeroe superHeroe) - start");

		 Assert.notNull(superHeroe.getId(),
		      "SuperHeroe id no puede ser null para actualizar un SuperHeroe");
		 if (superHeroesRepository.findById(superHeroe.getId()) == null) {
			 throw new NotFoundException("No existe el super héroe con ese id");
		 }
		 
		 SuperHeroe superHeroeReturn = superHeroesRepository.save(superHeroe);
		 log.debug("update(SuperHeroe superHeroe) - end");
		 
		 return superHeroeReturn;
	}    

}
