package net.ostemplate.app.productos.models.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ostemplate.app.productos.models.dao.TiendaRepository;
import net.ostemplate.app.productos.models.entity.Tienda;

@Service
public class TiendaServiceImpl implements TiendaServiceI{
	
	@Autowired
	private TiendaRepository tiendaRepository;
	
	@Override
	@Transactional
	public String actualizaTienda(String nombreTienda) {
		Tienda tienda = new Tienda(nombreTienda);
		return tiendaRepository.save(tienda).getNombreTienda();
		
	}
	
	@Override
	@Transactional
	public String getNombreDeTienda() {
		return tiendaRepository.findById(1L).orElse(null).getNombreTienda();
	}

}
