package net.ostemplate.app.productos.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="direccion_pedidos")
public class DireccionPedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8609891231808781722L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String via;
	private Long numero;
	private Long cp;
	private String pronvicia;
	private String localidad;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Pedido pedido;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Long getCp() {
		return cp;
	}
	public void setCp(Long cp) {
		this.cp = cp;
	}
	public String getPronvicia() {
		return pronvicia;
	}
	public void setPronvicia(String pronvicia) {
		this.pronvicia = pronvicia;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
		
	

}
