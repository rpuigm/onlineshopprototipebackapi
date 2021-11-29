package net.ostemplate.app.productos.models.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ostemplate.app.productos.models.dao.ComprasRepository;
import net.ostemplate.app.productos.models.entity.Cesta;
import net.ostemplate.app.productos.models.entity.ProductoCantidad;

@Service
public class CestaServiceImpl implements CestaServiceI {

	@Autowired
	private ComprasRepository comprasRepository;

	@Override
	@Transactional
	public Cesta guardaCesta(Cesta cesta) {
		return comprasRepository.save(cesta);
	}

	@Override
	@Transactional
	public List<Cesta> listaCestas() {
		return (List<Cesta>) comprasRepository.findAll();
	}

	@Override
	@Transactional
	public Cesta buscarCestaPorUsuarioId(Long idUsuario) {
		return comprasRepository.findByIdUsuario(idUsuario);
	}
	
	@Override
	@Transactional
	public Cesta actualizaCesta (Cesta cesta) {
		return comprasRepository.save(cesta);
	}


	@Override
	@Transactional
	public Cesta eliminarDeLaCesta(Long idUsuario, Long idProducto) {
		Cesta cesta = comprasRepository.findByIdUsuario(idUsuario);
		List<ProductoCantidad> listaProductoCantidad = cesta.getProductoCantidad();

		if (listaProductoCantidad != null) {
			listaProductoCantidad.stream().filter(producto -> producto.getIdProducto() == idProducto).findAny()
					.map(i -> disminuye(i));

			listaProductoCantidad.removeIf(p -> p.getCantidad() <= 0);

		}

		cesta.setProductoCesta(listaProductoCantidad);
		return guardaCesta(cesta);

	}

	private ProductoCantidad incrementa(ProductoCantidad productoCantidad) {
		productoCantidad.setCantidad(productoCantidad.getCantidad() + 1L);
		return productoCantidad;
	}

	private ProductoCantidad disminuye(ProductoCantidad productoCantidad) {
		productoCantidad.setCantidad(productoCantidad.getCantidad() - 1L);
		return productoCantidad;
	}

	private ProductoCantidad mapToProductoCantidad(Long idProducto) {
		ProductoCantidad productoCantidad = new ProductoCantidad();
		productoCantidad.setCantidad(1L);
		productoCantidad.setIdProducto(idProducto);
		return productoCantidad;
	}

}
