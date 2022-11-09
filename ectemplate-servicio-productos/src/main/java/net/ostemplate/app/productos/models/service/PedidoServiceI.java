package net.ostemplate.app.productos.models.service;

import java.util.List;

import net.ostemplate.app.productos.models.entity.Pedido;

public interface PedidoServiceI {

	List<Pedido> recuperaPedidosPorIdUsario(Long id);

	Pedido guardaPedido(Pedido pedido);

	Pedido findById(Long id);

	void borraPedido(Long id);

	List<Pedido> recuperaPedidosPorEstado(String estado);

	List<Pedido> recuperaPedidos();


}
