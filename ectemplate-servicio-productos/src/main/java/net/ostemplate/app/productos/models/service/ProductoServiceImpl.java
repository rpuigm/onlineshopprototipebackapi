package net.ostemplate.app.productos.models.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ostemplate.app.productos.models.dao.ProductoRepository;
import net.ostemplate.app.productos.models.entity.Producto;
import net.ostemplate.app.productos.models.entity.ProductoCaracteristicas;
import net.ostemplate.app.productos.models.entity.ProductoEspecificaciones;

@Service
public class ProductoServiceImpl implements ProductoServiceI{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto insertProducto(Producto producto) {
		ProductoCaracteristicas pc = new ProductoCaracteristicas();
		ProductoEspecificaciones pe = new ProductoEspecificaciones();
		pe.setClaveEspecificacion("pruebaClave");
		pe.setDescripcionEspecificacion("pruebaDescript");
		List<ProductoEspecificaciones> lpe = new ArrayList<ProductoEspecificaciones>();
		lpe.add(pe);
		pc.setDescripción("prueba total");
		pc.setProductoEspecificaciones(lpe);
		return productoRepository.save(producto);
	}

	@Override
	@Transactional
	public void borrarProducto(Long id) {
		productoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public List<Producto> buscarPorNombre(String nombre) {
		return productoRepository.findByNombre(nombre);
	}

	@Override
	@Transactional
	public List<Producto> buscarPorContieneEnNombre(String nombre) {
		return productoRepository.findByNombreLike("%"+nombre+"%");
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		
		if (productoRepository.existsById(producto.getId()))
			return productoRepository.save(producto);
		return producto;
	}

}
