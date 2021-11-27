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

@Entity
@Table(name="cestas")
public class Cesta implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	private Long idUsuario;
	private boolean activa;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_id_cesta")
	private List<ProductoCantidad> productoCesta;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<ProductoCantidad> getProductoCesta() {
		return productoCesta;
	}




	public void setProductoCesta(List<ProductoCantidad> productoCesta) {
		this.productoCesta = productoCesta;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = -2571360982612243290L;

}
