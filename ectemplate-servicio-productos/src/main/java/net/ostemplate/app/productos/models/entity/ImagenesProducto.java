package net.ostemplate.app.productos.models.entity;

public class ImagenesProducto {
	
	private Long id;
	
	private String nombreImagen;
	private String descripcionImagen;
	private byte[] imagen;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	

}
