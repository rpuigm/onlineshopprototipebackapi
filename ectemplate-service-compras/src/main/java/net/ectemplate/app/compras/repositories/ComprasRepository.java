package net.ectemplate.app.compras.repositories;

import org.springframework.data.repository.CrudRepository;

import net.ectemplate.app.compras.entities.Cesta;

public interface ComprasRepository extends CrudRepository<Cesta, Long> {

}
