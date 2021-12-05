package net.ostemplate.app.productos.models.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ostemplate.app.productos.models.dao.TiendaRepository;
import net.ostemplate.app.productos.models.entity.Tienda;

@Service
public class TiendaServiceImpl implements TiendaServiceI {

	@Autowired
	private TiendaRepository tiendaRepository;

	@Override
	@Transactional
	public String actualizaTienda(String nombreTienda) {
		Tienda tienda = new Tienda();
		tienda.setId(1L);
		tienda.setNombreTienda(nombreTienda);
		tienda = tiendaRepository.save(tienda);
		return tienda.getNombreTienda();

	}
	@Override
	@Transactional
	public Tienda guardaTienda(Tienda tienda) {
		return tiendaRepository.save(tienda);
		
	}

	@Override
	@Transactional
	public Tienda getNombreDeTienda() {
		return tiendaRepository.findById(1L).orElse(null);
	}

}
