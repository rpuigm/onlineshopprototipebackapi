package net.ostemplate.app.productos.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tienda")
public class Tienda implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2123667047833651369L;
	private String nombreTienda;

	@Id
	@Column(name="id")
	private Long id;
	
	public String getNombreTienda() {
		return nombreTienda;
	}

	public void setNombreTienda(String nombreTienda) {
		this.nombreTienda = nombreTienda;
	}
	
	

}