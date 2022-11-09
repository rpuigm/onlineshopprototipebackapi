package net.ostemplate.app.productos.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Tienda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2123667047833651369L;
	private String nombreTienda;

	@Id
	@Column(name = "id")
	private Long id;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreTienda() {
		return nombreTienda;
	}

	public void setNombreTienda(String nombreTienda) {
		this.nombreTienda = nombreTienda;
	}


}
