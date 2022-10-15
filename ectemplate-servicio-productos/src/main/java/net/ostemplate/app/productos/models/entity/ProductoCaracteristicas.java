package net.ostemplate.app.productos.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="productos_caracteristicas")
public class ProductoCaracteristicas implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_producto_caracteristicas")
	private Long idProductoCaracteristicas;
	
	private String descripcion;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_id_imagen_producto")
	private List<ImagenProducto> imagenesProducto;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_id_producto_especificacion")
	private List<ProductoEspecificaciones> productoEspecificaciones;

	public Long getIdProductoCaracteristicas() {
		return idProductoCaracteristicas;
	}

	public void setIdProductoCaracteristicas(Long idProductoCaracteristicas) {
		this.idProductoCaracteristicas = idProductoCaracteristicas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripción) {
		this.descripcion = descripción;
	}

	public List<ImagenProducto> getImagenesProducto() {
		return imagenesProducto;
	}

	public void setImagenesProducto(List<ImagenProducto> imagenesProducto) {
		this.imagenesProducto = imagenesProducto;
	}

	public List<ProductoEspecificaciones> getProductoEspecificaciones() {
		return productoEspecificaciones;
	}

	public void setProductoEspecificaciones(List<ProductoEspecificaciones> productoEspecificaciones) {
		this.productoEspecificaciones = productoEspecificaciones;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5408344838258575620L;

}
