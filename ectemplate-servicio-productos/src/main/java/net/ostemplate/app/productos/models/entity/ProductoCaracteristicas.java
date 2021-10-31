package net.ostemplate.app.productos.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="productos_caracteristicas")
public class ProductoCaracteristicas implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_producto_caracteristicas")
	private Long idProductoCaracteristicas;
	
	private String descripción;
	
	@OneToMany
	private List<ImagenesProducto> imagenesProducto;
	
	@OneToMany
	private List<ProductoEspecificaciones> productoEspecificaciones;

	public Long getIdProductoCaracteristicas() {
		return idProductoCaracteristicas;
	}

	public void setIdProductoCaracteristicas(Long idProductoCaracteristicas) {
		this.idProductoCaracteristicas = idProductoCaracteristicas;
	}


	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 5408344838258575620L;

}
