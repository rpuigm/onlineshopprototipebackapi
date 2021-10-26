package net.ostemplate.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ostemplate.app.productos.models.dao.ProductoDao;
import net.ostemplate.app.productos.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	public void insertProducto(Producto producto) {
		productoDao.save(producto);
	}

	@Override
	public void borrarProducto(Long id) {
		productoDao.deleteById(id);
	}

	@Override
	public Producto buscarPorNombre(String nombre) {
		return null;
	}

}
