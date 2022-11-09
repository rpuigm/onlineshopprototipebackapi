package net.ostemplate.app.productos.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@MappedSuperclass
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String nombre;
	private Double precio;
	private String categoria;
	private Double valoracion;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_idProductoCaracteristicas")
	private ProductoCaracteristicas productoCaracteristicas;

	@OneToMany
	@JoinColumn(
			name = "idProducto",
			foreignKey = @ForeignKey(name = "id_producto", value = ConstraintMode.CONSTRAINT))
	private List<ProductoCantidad> productoCantidad;

	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = -2671150384369555985L;

}
