package net.ostemplate.app.productos.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	private String estado;
	private Double total;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_idPedido_producto")
	private List<ProductosPedido> listaProcutosPedido;
	
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="fk_idPedido_direccion")
    private DireccionPedido direccionPedido;
	
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
	public List<ProductosPedido> getListaProcutosPedido() {
		return listaProcutosPedido;
	}
	public void setListaProcutosPedido(List<ProductosPedido> listaProcutosPedido) {
		this.listaProcutosPedido = listaProcutosPedido;
	}
	public DireccionPedido getDireccionPedido() {
		return direccionPedido;
	}
	public void setDireccionPedido(DireccionPedido direccionPedido) {
		this.direccionPedido = direccionPedido;
	}
	
	

}
