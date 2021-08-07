package com.ostemplate.app.productos.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author ruben.puig
 * 
 * Persiste las categorías en las que se pueden
 * clasificar los productos.
 *
 */
@Entity
@Table(name="categorias")
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1701752950355608516L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Long categoriaPadre;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getCategoriaPadre() {
		return categoriaPadre;
	}
	public void setCategoriaPadre(Long categoriaPadre) {
		this.categoriaPadre = categoriaPadre;
	}

	
}
