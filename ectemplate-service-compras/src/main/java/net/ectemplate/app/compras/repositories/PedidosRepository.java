package net.ectemplate.app.compras.repositories;

import org.springframework.data.repository.CrudRepository;

import net.ectemplate.app.compras.entities.Pedido;

public interface PedidosRepository extends CrudRepository<Pedido, Long>{

}
