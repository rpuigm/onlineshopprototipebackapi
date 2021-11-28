package net.ostemplate.app.productos.models.service;

import java.util.List;
import java.util.Optional;

import net.ostemplate.app.productos.models.entity.Pedido;

public interface PedidoServiceI {

	List<Pedido> recuperaPedidosPorIdUsario(Long id);

	Optional<Pedido> recuperaPedidoPorId(Long id);

	Pedido guardaPedido(Pedido pedido);
	

}
