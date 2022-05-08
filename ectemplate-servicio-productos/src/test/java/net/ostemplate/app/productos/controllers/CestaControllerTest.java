package net.ostemplate.app.productos.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import net.ostemplate.app.productos.mappers.CestaMapper;

@ExtendWith(MockitoExtension.class)
public class CestaControllerTest {

	@InjectMocks
	private CestaController cestaController;

	@Test
	private void recuperaCestaPorIdUsuarioTest() {
		assertEquals(cestaController.recuperaCestaPorIdUsuario(1L),
				CestaMapper.mapToCesta());
	}

}
