package com.pruebaSpringBoot.superHeroes.mapping;

import java.util.ArrayList;
import java.util.List;

import com.pruebaSpringBoot.superHeroes.entity.SuperHeroe;
import com.pruebaSpringBoot.superHeroes.model.SuperHeroeDTO;

public final class SuperHeroeMapping {
	
	public static SuperHeroeDTO mappingToSuperHeroeDTO(SuperHeroe superHeroe) {
		SuperHeroeDTO superHeroeDTO = new SuperHeroeDTO();
	    superHeroeDTO.setId(superHeroe.getId());
	    superHeroeDTO.setName(superHeroe.getName());
	    return superHeroeDTO;
	}
	
	public static SuperHeroe mappingToSuperHeroeEntity(SuperHeroeDTO superHeroeDTO) {
		SuperHeroe superHeroe = new SuperHeroe();
		superHeroe.setId(superHeroeDTO.getId());
		superHeroe.setName(superHeroeDTO.getName());
	    return superHeroe;
	}
	
	public static List<SuperHeroeDTO> mappingToListSuperHeroeDTO(List<SuperHeroe> superHeroes) {
		List<SuperHeroeDTO> superHeroesDTO = new ArrayList<SuperHeroeDTO>();

		for (SuperHeroe superHeroe : superHeroes) {
			superHeroesDTO.add(mappingToSuperHeroeDTO(superHeroe));
		}

		return superHeroesDTO;
	}
	
	public static List<SuperHeroe> mappingToListSuperHeroeEntity(List<SuperHeroeDTO> superHeroesDTO) {
		List<SuperHeroe> superHeroes = new ArrayList<SuperHeroe>();

		for (SuperHeroeDTO superHeroeDTO : superHeroesDTO) {
			superHeroes.add(mappingToSuperHeroeEntity(superHeroeDTO));
		}

		return superHeroes;
	}

}
;