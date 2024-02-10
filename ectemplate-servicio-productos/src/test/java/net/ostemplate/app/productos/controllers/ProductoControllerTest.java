package net.ostemplate.app.productos.controllers;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import net.ostemplate.app.productos.models.entity.Producto;
import net.ostemplate.app.productos.models.entity.ProductoCantidad;
import net.ostemplate.app.productos.models.entity.ProductoCaracteristicas;
import net.ostemplate.app.productos.models.entity.ProductoEntity;
import net.ostemplate.app.productos.models.service.FileService;
import net.ostemplate.app.productos.models.service.ProductoServiceI;

@ExtendWith(MockitoExtension.class)
public class ProductoControllerTest {

	@InjectMocks
	private ProductoController productoController;

	@Mock
	MultipartFile multiparteFile;

	@Mock
	ProductoServiceI productoServiceI;

	@Mock
	FileService fileService;
	
	@Mock
	InputStream inputStream;

	@Test
	public void subidaImagen() {
		try {
			Mockito.when(productoServiceI.findById(Mockito.anyLong())).thenReturn(mapToProductoDummy());
			Mockito.when(fileService.copyFile(Mockito.any(InputStream.class), Mockito.any(Path.class))).thenReturn(1L);
			Mockito.when(multiparteFile.getInputStream()).thenReturn(inputStream);
			Mockito.when(productoServiceI.modificarProducto(Mockito.any(ProductoEntity.class))).thenReturn(mapToProductoDummy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		productoController.subidaImagen(multiparteFile, 1L, "descripcion");

	}

	@Test
	public void detalleTest(){
		Producto producto = mapToProductoDummy();
		Mockito.when(productoServiceI.findById(Mockito.anyLong()))
			.thenReturn(producto);
		assertEquals(productoController.detalle(1L),producto);

	}

	private Producto mapToProductoDummy() {
		EasyRandom generator = new EasyRandom();
		Producto producto = generator.nextObject(Producto.class);
		producto.setProductoCaracteristicas(mapToProductoCaracteristicasDummy());
		return producto;
	}

	private ProductoCaracteristicas mapToProductoCaracteristicasDummy() {
		EasyRandom generator = new EasyRandom();
		return generator.nextObject(ProductoCaracteristicas.class);
	}

	private ProductoCantidad mapToProductoCantidadDummy() {
		EasyRandom generator = new EasyRandom();
		return generator.nextObject(ProductoCantidad.class);
	}

	private List<ProductoCantidad> mapToListProductoCantidad() {
		List<ProductoCantidad> listProductoCantidad = new ArrayList<>();
		listProductoCantidad.add(mapToProductoCantidadDummy());
		listProductoCantidad.add(mapToProductoCantidadDummy());
		listProductoCantidad.add(mapToProductoCantidadDummy());
		return listProductoCantidad;
	}
	


}
