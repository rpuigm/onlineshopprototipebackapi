package net.ectemplate.app.compras;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.util.Asserts;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import net.ectemplate.app.compras.entities.Cesta;
import net.ectemplate.app.compras.entities.ProductoCantidad;
import net.ectemplate.app.compras.repositories.ComprasRepository;
import net.ectemplate.app.compras.services.CestaServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CestaServiceImplTest {

	@InjectMocks
	private CestaServiceImpl cestaServiceImpl;

	@Mock
	private ComprasRepository comprasRepository;

	@Test
	public void incluirEnCestaTest() {
		Mockito.when(comprasRepository.findByIdUsuarioAndActiva(Mockito.anyLong(), Mockito.anyBoolean()))
				.thenReturn(mapToCesta());
		Mockito.when(comprasRepository.save(Mockito.any(Cesta.class))).thenReturn(mapToCesta());
		
		assertSame(cestaServiceImpl.incluirEnCesta(1L, 1L).getProductoCesta().get(0).getCantidad(), 1L);
		assertSame(cestaServiceImpl.incluirEnCesta(1L, 0L).getProductoCesta().get(0).getCantidad(), 1L);

	}

	private Cesta mapToCesta() {
		Cesta cesta = new Cesta();
		cesta.setIdUsuario(1L);
		cesta.setProductoCesta(mapToListaProductoCantidad());
		return cesta;

	}

	private List<ProductoCantidad> mapToListaProductoCantidad() {
		ProductoCantidad productoCantidad = new ProductoCantidad();
		productoCantidad.setIdProducto(1L);
		productoCantidad.setCantidad(1L);
		List<ProductoCantidad> listaProductoCantidad = new ArrayList<ProductoCantidad>();
		listaProductoCantidad.add(productoCantidad);
		return listaProductoCantidad;
	}
}
