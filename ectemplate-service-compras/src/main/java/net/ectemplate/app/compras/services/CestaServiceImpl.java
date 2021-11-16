package net.ectemplate.app.compras.services;

import org.springframework.beans.factory.annotation.Autowired;

import net.ectemplate.app.compras.entities.Cesta;
import net.ectemplate.app.compras.repositories.ComprasRepository;

public class CestaServiceImpl implements CestaServiceI{

	@Autowired
	private ComprasRepository comprasRepository;
	
	@Override
	public Cesta guardaCesta(Cesta cesta) {
		return comprasRepository.save(cesta);
	}


}
