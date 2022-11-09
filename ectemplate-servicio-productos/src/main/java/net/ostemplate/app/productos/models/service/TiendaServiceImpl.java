package net.ostemplate.app.productos.models.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ostemplate.app.productos.models.dao.TiendaRepository;
import net.ostemplate.app.productos.models.entity.TiendaEntity;

@Service
public class TiendaServiceImpl implements TiendaServiceI {

	@Autowired
	private TiendaRepository tiendaRepository;

	@Override
	@Transactional
	public String actualizaTienda(String nombreTienda) {
		TiendaEntity tiendaEntity = new TiendaEntity();
		tiendaEntity.setId(1L);
		tiendaEntity.setNombreTienda(nombreTienda);
		tiendaEntity = tiendaRepository.save(tiendaEntity);
		return tiendaEntity.getNombreTienda();

	}

	@Override
	@Transactional
	public TiendaEntity guardaTienda(TiendaEntity tiendaEntity) {
		return tiendaRepository.save(tiendaEntity);

	}

	@Override
	@Transactional
	public TiendaEntity getNombreDeTienda() {
		return tiendaRepository.findById(1L).orElse(null);
	}

}
