package net.ectemplate.app.compras.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6570243476131676038L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long idUsuario;
	private Long idCesta;
	private String estado;
	private Double total;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	@OneToOne
	@JoinColumn(name="fk_id_pedido")
	public Long getIdCesta() {
		return idCesta;
	}
	public void setIdCesta(Long idCesta) {
		this.idCesta = idCesta;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	

}
