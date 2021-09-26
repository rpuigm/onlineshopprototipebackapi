package net.ectemplate.app.clientes.model.dao;
import org.springframework.data.repository.CrudRepository;

import net.ectemplate.app.clientes.model.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long>{

}
