package net.ostemplate.app.productos.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import net.ostemplate.app.productos.models.dao.ProductoRepository;
import net.ostemplate.app.productos.models.entity.ImagenProducto;
import net.ostemplate.app.productos.models.entity.Producto;
import net.ostemplate.app.productos.models.entity.ProductoCaracteristicas;
import net.ostemplate.app.productos.models.entity.ProductoEspecificaciones;
import net.ostemplate.app.productos.models.service.ProductoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceImplTest {

	@InjectMocks
	ProductoServiceImpl productoServiceImpl;
	
	@Mock
	ProductoRepository proRepository;
	
	@Test
	public void insertarProductoTest() throws ParseException {
		Mockito.when(proRepository.save(Mockito.any(Producto.class))).thenReturn(mapToProducto());
		productoServiceImpl.insertProducto(mapToProducto());
	}
	
	@Test
	public void buscarPorContieneEnNombre() throws ParseException {
		Mockito.when(proRepository.findByNombreLike(Mockito.anyString())).thenReturn(mapToListaProducto());
		productoServiceImpl.buscarPorContieneEnNombre("prueba");
		
	}
	
	private List<Producto> mapToListaProducto() throws ParseException{
		List<Producto> listaProductos = new ArrayList<Producto>();
		listaProductos.add(mapToProducto());
		listaProductos.add(mapToProducto());
		listaProductos.add(mapToProducto());
		return listaProductos;
		
	}
	
	private Producto mapToProducto() throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
		Producto producto = new Producto();
		producto.setCategoria("categoria");
		producto.setId(1L);
		producto.setCategoria("nombre");
		producto.setCreateAt(simpleDateFormat.parse("10/10/2021"));
		producto.setProductoCaracteristicas(mapToProductoCaracteristicas());
		return producto;
		
	}
	
	private ProductoEspecificaciones mapToProductoEspecificaciones() {
		ProductoEspecificaciones productoEspecificaciones = new ProductoEspecificaciones();
		productoEspecificaciones.setClaveEspecificacion("clave");
		productoEspecificaciones.setDescripcionEspecificacion("descripcion");
		productoEspecificaciones.setIdProductoEspecificacion(1L);
		return productoEspecificaciones;
	}
	
	private ProductoCaracteristicas mapToProductoCaracteristicas() {
		ProductoCaracteristicas productoCaracteristicas = new ProductoCaracteristicas();
		List<ImagenProducto> listaImagenesProducto = new ArrayList<ImagenProducto>();
		listaImagenesProducto.add(mapToImagenProducto());
		productoCaracteristicas.setImagenesProducto(listaImagenesProducto);
		productoCaracteristicas.setDescripcion("descripcion");
		List<ProductoEspecificaciones> listaProductoEspecificaciones = new ArrayList<ProductoEspecificaciones>();
		listaProductoEspecificaciones.add(mapToProductoEspecificaciones());
		productoCaracteristicas.setProductoEspecificaciones(listaProductoEspecificaciones);
		return productoCaracteristicas;
	}
	
	private ImagenProducto mapToImagenProducto() {
		ImagenProducto imagenProducto = new ImagenProducto();
		imagenProducto.setDescripcionImagen("imagen descripcion");
		imagenProducto.setIdImageneProducto(1L);
		imagenProducto.setImagen("imagen");
		imagenProducto.setNombreImagen("nombre");
		return imagenProducto;
	}

		
}
