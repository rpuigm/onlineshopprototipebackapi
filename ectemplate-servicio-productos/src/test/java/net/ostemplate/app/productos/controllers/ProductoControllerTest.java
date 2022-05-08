package net.ostemplate.app.productos.controllers;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

@ExtendWith(MockitoExtension.class)
public class ProductoControllerTest {
	
	@InjectMocks
	private ProductoController productoController;
	
	@Mock
	MultipartFile multiparteFile;
	
	@Test
	@Disabled
	public void subidaImagen() {
		productoController.subidaImagen(multiparteFile, 1L, "descripcion");
		
	}
		
}
