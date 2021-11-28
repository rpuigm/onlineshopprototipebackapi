package net.ostemplate.app.productos.models.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ostemplate.app.productos.models.dao.PedidoRepository;
import net.ostemplate.app.productos.models.entity.Pedido;

@Service
public class PedidoServiceImpl implements PedidoServiceI {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	@Transactional
	public List<Pedido> recuperaPedidosPorIdUsario(Long id){
		return pedidoRepository.findByIdUsuario(id);
		
	}
	
	@Override
	@Transactional
	public Optional<Pedido> recuperaPedidoPorId(Long id) {
		return pedidoRepository.findById(id);
	}
	
	@Override
	@Transactional
	public Pedido guardaPedido (Pedido pedido) {
		return pedidoRepository.save(null);
	}

}
