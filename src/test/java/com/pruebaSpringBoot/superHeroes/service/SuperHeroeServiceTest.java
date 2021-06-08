package com.pruebaSpringBoot.superHeroes.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pruebaSpringBoot.superHeroes.entity.SuperHeroe;
import com.pruebaSpringBoot.superHeroes.model.SuperHeroeDTO;
import com.pruebaSpringBoot.superHeroes.repository.SuperHeroesRepository;

import javassist.NotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SuperHeroeServiceTest {

	  @MockBean
	  private SuperHeroesRepository repository;


	  // This bean must be created by Spring so validations can be applied
	  @Autowired
	  private SuperHeroesService service;
	  
	  @Test
	  public void findAll_ReturnsListSuperHeroe() {

		List<SuperHeroe> list = new ArrayList<SuperHeroe>();
		for (long i = 1; i <= 5; i++) {
			list.add(generarMockSuperHeroe(i, "SuperHeroe" + String.format("%03d", i)));
		}
	    BDDMockito.given(
	        repository.findAll())
	        .willReturn(list);
	    
	    List<SuperHeroeDTO> listDTO = service.findAll();
	    
	    // then: Devuelve el listado de SuperHeroes
	    Assertions.assertThat(listDTO).as("isNotNull()").isNotNull();
	    Assertions.assertThat(listDTO.size()).as("getSize()").isEqualTo(5);
	   
	  }
	  
	  @Test
	  public void findById_ReturnsSuperHeroe() {
	    // given: Un SuperHeroe con el id buscado
	    Long idBuscado = 1L;
	    BDDMockito.given(repository.findById(idBuscado)).willReturn(generarMockSuperHeroe(idBuscado, "SuperHeroe"));

	    // when: Buscamos el SuperHeroe por su id
	    SuperHeroeDTO superHeroe = service.findById(idBuscado);

	    // then: Devuelve el SuperHeroe
	    Assertions.assertThat(superHeroe).as("isNotNull()").isNotNull();
	    Assertions.assertThat(superHeroe.getId()).as("getId()").isEqualTo(idBuscado);
	    Assertions.assertThat(superHeroe.getName()).isEqualTo("SuperHeroe");
	  }
	
	  @Test
	  public void delete_WithExistingId_DoesNotThrowAnyException() {
	    // given: id a borrar
		Long idBorrado = 1L;
		SuperHeroe superHeroe = generarMockSuperHeroe(1L, "SuperHeroe");
		BDDMockito.given(repository.findById(ArgumentMatchers.<Long>any())).willReturn(superHeroe);
		BDDMockito.doNothing().when(repository).deleteById(ArgumentMatchers.<Long>any());

		 Assertions.assertThatCode(
			        // when: delete by existing id
			        () -> service.delete(idBorrado))
			        // then: no exception is thrown
			        .doesNotThrowAnyException();
	  }
	  
	  @Test
	  public void delete_WithNoExistingId_ThrowsNotFoundException() throws Exception {
	    // given: no existing id
	    Long id = 1L;

	    BDDMockito.given(repository.findById(ArgumentMatchers.<Long>any())).willReturn(null);

	    Assertions.assertThatThrownBy(
	        // when: delete
	        () -> service.delete(id))
	        // then: se lanza NotFoundException 
	        .isInstanceOf(NotFoundException.class);
	  }
	  
	  
	  @Test
	  public void update_WithNoExistingId_ThrowsNotFoundException() {
	    // given: Un SuperHeroe a modificar con null
		SuperHeroe superHeroe = generarMockSuperHeroe(1L, "SuperHeroe");
	    BDDMockito.given(repository.findById(ArgumentMatchers.<Long>any())).willReturn(null);

	    // when: modificamos el superHeroe
	    // then: lanza un NotFoundException
	    Assertions.assertThatThrownBy(() -> service.update(superHeroe))
	        .isInstanceOf(NotFoundException.class);
	    
	  }
	  
	  @Test
	  public void update_ReturnsSuperHeroe(){
	    // given: Un SuperHeroe a modificar
		Long idActualizar = 1L;
		SuperHeroe superHeroe = generarMockSuperHeroe(idActualizar, "SuperHeroe");
		SuperHeroe superHeroeActualizar = generarMockSuperHeroe(idActualizar, "SuperMan");
		BDDMockito.given(repository.findById(idActualizar)).willReturn(superHeroe);
	    BDDMockito.given(repository.save(superHeroeActualizar)).willReturn(superHeroeActualizar);

		 Assertions.assertThatCode(
			        // when: modifica el superHeroe
			        () -> service.update(superHeroe))
			        // then: no se lanza excepcion
			        .doesNotThrowAnyException();
	   
	    // then: devuelve el super heroe actualizado
	    Assertions.assertThat(superHeroe).as("isNotNull()").isNotNull();
	    Assertions.assertThat(superHeroe.getName()).isNotEqualTo(superHeroeActualizar.getName());
	    
	  }
	  
	  private SuperHeroe generarMockSuperHeroe(Long id, String nombre) {
			SuperHeroe superHeroe = new SuperHeroe(id, nombre);
			return superHeroe;
	  }
	  

	 
}
