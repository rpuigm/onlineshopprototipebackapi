package net.ostemplate.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ostemplate.app.productos.models.dao.ProductoCantidadRepository;
import net.ostemplate.app.productos.models.dao.ProductoRepository;
import net.ostemplate.app.productos.models.entity.Producto;

@Service
public class ProductoServiceImpl implements ProductoServiceI {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private ProductoCantidadRepository productoCantidadRepository;

	@Autowired
	private CestaServiceI cestaServiceI;

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
		System.out.println("descripcion---" + producto.getProductoCaracteristicas().getDescripcion());
		return productoRepository.save(producto);
	}

	@Override
	@Transactional
	public void borrarProducto(Long id) {
		if (!productoCantidadRepository.findAllByIdProducto(id).equals(null))
			cestaServiceI.eliminarUnProductoDeLasCestas(id);
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
		return productoRepository.findByNombreLike("%" + nombre + "%");
	}

	@Override
	@Transactional
	public Producto modificarProducto(Producto producto) {
		if (productoRepository.existsById(producto.getId()))
			return productoRepository.save(producto);
		return producto;
	}

	@Override
	@Transactional
	public void borrarUnProducto(Producto producto) {
		if (!productoCantidadRepository.findAllByIdProducto(producto.getId()).equals(null))
			cestaServiceI.eliminarUnProductoDeLasCestas(producto.getId());
		productoRepository.delete(producto);

	}

}
