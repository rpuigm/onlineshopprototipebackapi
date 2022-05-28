package net.ostemplate.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ostemplate.app.productos.models.dao.ProductoCantidadRepository;
import net.ostemplate.app.productos.models.dao.ProductoRepository;
import net.ostemplate.app.productos.models.entity.Producto;
import net.ostemplate.app.productos.models.entity.ProductoEntity;

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
	public List<ProductoEntity> findAll() {
		return (List<ProductoEntity>) productoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto insertProducto(ProductoEntity productoEntity) {
		return productoRepository.save(productoEntity);
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
	public List<ProductoEntity> buscarPorNombre(String nombre) {
		return productoRepository.findByNombre(nombre);
	}

	@Override
	@Transactional
	public List<ProductoEntity> buscarPorContieneEnNombre(String nombre) {
		return productoRepository.findByNombreLike("%" + nombre + "%");
	}

	@Override
	@Transactional
	public Producto modificarProducto(ProductoEntity productoEntity) {
		if (productoRepository.existsById(productoEntity.getId()))
			return productoRepository.save(productoEntity);
		return productoEntity;
	}

	@Override
	@Transactional
	public void borrarUnProducto(ProductoEntity productoEntity) {
		if (!(productoCantidadRepository.findAllByIdProducto(productoEntity.getId())==null))
			cestaServiceI.eliminarUnProductoDeLasCestas(productoEntity.getId());
		productoRepository.delete(productoEntity);

	}

}
