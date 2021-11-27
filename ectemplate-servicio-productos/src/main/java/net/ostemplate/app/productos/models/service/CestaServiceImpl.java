package net.ostemplate.app.productos.models.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		return comprasRepository.findByIdUsuarioAndActiva(idUsuario, true);
	}

	@Override
	@Transactional
	public Cesta incluirEnCesta(Long idUsuario, Long idProducto) {
		Cesta cesta = new Cesta();
		List<ProductoCantidad> listaProductoCantidad = new ArrayList<ProductoCantidad>();
		if (null == idUsuario) {
			cesta = comprasRepository.findByIdUsuarioAndActiva(idUsuario, true);

			listaProductoCantidad = cesta.getProductoCesta();

			if (listaProductoCantidad != null) {
				Optional<ProductoCantidad> productoCantidad = listaProductoCantidad.stream()
						.filter(producto -> producto.getIdProducto() == idProducto).findAny().map(i -> incrementa(i));

				if (productoCantidad.isEmpty())
					listaProductoCantidad.add(mapToProductoCantidad(idProducto));

			} else {
				listaProductoCantidad.add(mapToProductoCantidad(idProducto));

			}
			listaProductoCantidad.add(mapToProductoCantidad(idProducto));
		}

		cesta.setProductoCesta(listaProductoCantidad);
		return guardaCesta(cesta);
	}

	@Override
	@Transactional
	public Cesta eliminarDeLaCesta(Long idUsuario, Long idProducto) {
		Cesta cesta = comprasRepository.findByIdUsuarioAndActiva(idUsuario, true);
		List<ProductoCantidad> listaProductoCantidad = cesta.getProductoCesta();

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
