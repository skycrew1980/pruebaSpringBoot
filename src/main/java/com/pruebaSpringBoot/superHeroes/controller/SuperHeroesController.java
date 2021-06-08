package com.pruebaSpringBoot.superHeroes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaSpringBoot.superHeroes.entity.SuperHeroe;
import com.pruebaSpringBoot.superHeroes.model.SuperHeroeDTO;
import com.pruebaSpringBoot.superHeroes.service.SuperHeroesService;

import javassist.NotFoundException;

@RestController
public class SuperHeroesController {

	@Autowired
    private SuperHeroesService superHeroesService;
 
	@GetMapping("/superHeroes")
    public List<SuperHeroeDTO> allSuperHeroes() {

        return superHeroesService.findAll();
    }
	
	@GetMapping("/superHeroes/{id}")
	public SuperHeroeDTO findById(@PathVariable Long id) {

	    return superHeroesService.findById(id);
	}
	
	@GetMapping("/superHeroes/{name}")
	public List<SuperHeroeDTO> findByName(@PathVariable String name) {

	    return superHeroesService.findByName(name);
	}
	
    @DeleteMapping("/superHeroes/{id}")
    public void delete(@PathVariable Long id) throws NotFoundException {

        superHeroesService.delete(id);
    }
    
    @PutMapping("/superHeroes/{id}")
    public SuperHeroe update(@PathVariable SuperHeroe superHeroe) throws NotFoundException  {

        return superHeroesService.update(superHeroe);
    }
}
