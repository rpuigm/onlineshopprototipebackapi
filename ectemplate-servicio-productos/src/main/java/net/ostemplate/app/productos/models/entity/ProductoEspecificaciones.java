package net.ostemplate.app.productos.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos_especificaciones")
public class ProductoEspecificaciones implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_producto_especificacion")
	private Long idProductoEspecificacion;
	
	private String claveEspecificacion;
	private String descripcionEspecificacion;
	public Long getIdProductoEspecificacion() {
		return idProductoEspecificacion;
	}
	public void setIdProductoEspecificacion(Long idProductoEspecificacion) {
		this.idProductoEspecificacion = idProductoEspecificacion;
	}
	public String getClaveEspecificacion() {
		return claveEspecificacion;
	}
	public void setClaveEspecificacion(String claveEspecificacion) {
		this.claveEspecificacion = claveEspecificacion;
	}
	public String getDescripcionEspecificacion() {
		return descripcionEspecificacion;
	}
	public void setDescripcionEspecificacion(String descripcionEspecificacion) {
		this.descripcionEspecificacion = descripcionEspecificacion;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8328511308302986532L;
	
}
