package net.ostemplate.app.productos.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "imagenes_productos")
public class ImagenProducto implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_imagen_producto")
	private Long idImagenProducto;

	private String nombreImagen;
	private String descripcionImagen;
	private String imagen;


	public Long getIdImageneProducto() {
		return idImagenProducto;
	}

	public void setIdImageneProducto(Long idImagenProducto) {
		this.idImagenProducto = idImagenProducto;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public String getDescripcionImagen() {
		return descripcionImagen;
	}

	public void setDescripcionImagen(String descripcionImagen) {
		this.descripcionImagen = descripcionImagen;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -410218856375394485L;

}
