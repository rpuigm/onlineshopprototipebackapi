package net.ostemplate.app.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.ostemplate.app.productos.models.entity.Pedido;
import net.ostemplate.app.productos.models.service.PedidoServiceI;

@RestController
public class PedidoController {
	
	@Autowired
	private PedidoServiceI pedidoServiceI;
	
	@GetMapping("/pedidos/recupera-pedidos-usuario/{id}")
	public List<Pedido> recuperaPedidoPorId(@PathVariable Long id) {
		return pedidoServiceI.recuperaPedidosPorIdUsario(id);
		
	}
	@GetMapping("/pedidos/recupera-pedido/{id}")
	public Pedido recuperaPedidoId(@PathVariable Long id) {
		return pedidoServiceI.findById(id);
		
	}
	
	@PostMapping("/pedidos/actualiza-pedido")
	public Pedido actualizaPedido (@RequestBody Pedido pedido) {
		return pedidoServiceI.guardaPedido(pedido);
	}
	
	@DeleteMapping("/pedidos/borra-pedido/{id}")
	public void actualizaPedido (@PathVariable Long id) {
		pedidoServiceI.borraPedido(id);
	}

}
