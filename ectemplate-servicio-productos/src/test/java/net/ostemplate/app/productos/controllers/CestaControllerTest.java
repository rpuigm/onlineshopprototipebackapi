package net.ostemplate.app.productos.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import net.ostemplate.app.productos.mappers.CestaMapper;
import net.ostemplate.app.productos.models.entity.Cesta;
import net.ostemplate.app.productos.models.entity.CestaEntity;
import net.ostemplate.app.productos.models.entity.ProductoCantidad;
import net.ostemplate.app.productos.models.service.CestaServiceI;

@ExtendWith(MockitoExtension.class)
public class CestaControllerTest {

    @Mock
    private CestaServiceI cestaServiceI;

	@InjectMocks
	private CestaController cestaController;

	@Test
	private void recuperaCestaPorIdUsuarioTest() {
		assertEquals(cestaController.recuperaCestaPorIdUsuario(1L),
				CestaMapper.mapToCesta());
	}

	@Test
    public void testRecuperaCestaPorIdUsuario() {
        Long idUsuario = 1L;
        Cesta cesta = new Cesta(); // crea una cesta ficticia para el test
        when(cestaServiceI.buscarCestaPorUsuarioId(idUsuario)).thenReturn(cesta);
        Cesta resultado = cestaController.recuperaCestaPorIdUsuario(idUsuario);
        assertEquals(cesta, resultado);

    }

    @Test
    public void testActualizaCesta() {
        Cesta cesta = newCestabyRandom(); // crea una cesta ficticia para el test
		CestaEntity cestaEntity= CestaMapper.mapToCestaEntityFromCesta(cesta);
        when(cestaServiceI.actualizaCesta(Mockito.any(CestaEntity.class)))
			.thenReturn(cestaEntity);
        Cesta response = cestaController.actualizaCesta(cesta);
        assertEquals(cestaEntity, response);

    }

    @Test
    public void testListaCestas() {
		List<CestaEntity> listCestasEntity= new ArrayList<>();
		listCestasEntity = createListCestaEntitiesByRandom();
        when(cestaServiceI.listaCestas()).thenReturn(listCestasEntity);
        List<Cesta> resultado = cestaController.listaCestas();
        assertEquals(listCestasEntity, resultado);

    }

	@Test
	public void recuperaCestaPorIdUsuarioEliminandoTest(){
		doNothing().when(cestaServiceI).eliminaCesta(Mockito.any(CestaEntity.class));
		cestaController.recuperaCestaPorIdUsuario(newCestabyRandom());
	}



	private Cesta newCestabyRandom (){
		Cesta cesta = new Cesta();
		cesta.setId(1L);
		cesta.setIdUsuario(2L);	
		List<ProductoCantidad> listaProductoCantidad = new ArrayList <>();
		listaProductoCantidad.add(newProductoCantidadByRandom());
		listaProductoCantidad.add(newProductoCantidadByRandom());
		listaProductoCantidad.add(newProductoCantidadByRandom());
		listaProductoCantidad.add(newProductoCantidadByRandom());
		cesta.setProductoCesta(listaProductoCantidad);
		return cesta;

	}

	private ProductoCantidad newProductoCantidadByRandom(){
		ProductoCantidad productoCantidad = new ProductoCantidad();
		productoCantidad.setCantidad(RandomUtils.nextLong(0,100));
		productoCantidad.setId(RandomUtils.nextLong(0, 100));
		productoCantidad.setIdProducto(RandomUtils.nextLong());
		return productoCantidad;

	}

	private List<CestaEntity> createListCestaEntitiesByRandom(){
		List<CestaEntity> listCestaEntity = new ArrayList<>();
		listCestaEntity.add(CestaMapper.mapToCestaEntityFromCesta(newCestabyRandom()));
		listCestaEntity.add(CestaMapper.mapToCestaEntityFromCesta(newCestabyRandom()));
		listCestaEntity.add(CestaMapper.mapToCestaEntityFromCesta(newCestabyRandom()));
		listCestaEntity.add(CestaMapper.mapToCestaEntityFromCesta(newCestabyRandom()));
		return listCestaEntity;
		
	}

	private List<Cesta> createListCesta(){
		List<Cesta> cesta = new ArrayList<>();
		cesta.add(newCestabyRandom());
		cesta.add(newCestabyRandom());
		cesta.add(newCestabyRandom());
		cesta.add(newCestabyRandom());
		return cesta;

	}


}
