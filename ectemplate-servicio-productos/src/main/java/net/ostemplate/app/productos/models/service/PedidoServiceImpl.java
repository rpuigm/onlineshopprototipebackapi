package net.ostemplate.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ostemplate.app.productos.models.dao.PedidoRepository;
import net.ostemplate.app.productos.models.entity.Pedido;

@Service
public class PedidoServiceImpl implements PedidoServiceI {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Pedido> recuperaPedidosPorIdUsario(Long id) {
		return pedidoRepository.findByIdUsuario(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Pedido findById(Long id) {
		return pedidoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Pedido guardaPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	@Transactional
	public void borraPedido(Long id) {
		pedidoRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pedido> recuperaPedidosPorEstado(String estado) {
		return pedidoRepository.findByEstado(estado);

	}

	@Override
	@Transactional(readOnly = true)
	public List<Pedido> recuperaPedidos() {
		return (List<Pedido>) pedidoRepository.findAll();

	}

}
