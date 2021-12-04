package net.ostemplate.app.productos.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.ostemplate.app.productos.models.entity.Pedido;

public interface PedidoRepository extends CrudRepository <Pedido, Long>{
	
	List<Pedido> findByIdUsuario (Long idUsuario);
	
	List<Pedido> findByEstado(String estado);

}
