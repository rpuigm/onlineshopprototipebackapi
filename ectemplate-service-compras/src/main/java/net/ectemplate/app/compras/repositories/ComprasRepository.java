package net.ectemplate.app.compras.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.ectemplate.app.compras.entities.Cesta;

@Repository
public interface ComprasRepository extends PagingAndSortingRepository<Cesta, Long> {

}
