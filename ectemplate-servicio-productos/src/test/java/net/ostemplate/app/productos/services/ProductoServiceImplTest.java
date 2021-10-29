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
import net.ostemplate.app.productos.models.entity.Producto;
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
		return Producto.builder()
				.categoria("categoria")
				.id(1L)
				.nombre("nombre")
				.createAt(simpleDateFormat.parse("10/10/2021"))
				.build();
		
	}

		
}
