package net.ostemplate.app.clientes.model.dao;
import org.springframework.data.repository.CrudRepository;

import net.ostemplate.app.clientes.model.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long>{

}
