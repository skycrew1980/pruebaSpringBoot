package com.pruebaSpringBoot.superHeroes.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "SUPERHEROE")
public class SuperHeroe implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4604827115461147427L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@NotNull
	private Long id;
	
	@Column(name = "NAME")
	@NotNull
	private String name;
	
	public SuperHeroe() {}

    public SuperHeroe(Long id, String name) {
    	this.id = id;
        this.name = name;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		SuperHeroe superHeroe = (SuperHeroe) o;
		return Objects.equals(id, superHeroe.id) && Objects.equals(name, superHeroe.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("SuperHeroe{");
		sb.append("id=").append(id.toString());
		sb.append(", name='").append(name).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
