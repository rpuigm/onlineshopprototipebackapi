package net.ostemplate.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.ostemplate.app.productos.models.entity.Producto;
import net.ostemplate.app.productos.models.service.ProductoServiceI;

@RestController
public class ProductoController {
	
	@Autowired
	private ProductoServiceI productoService;
	
	@GetMapping("/lista")
	public List<Producto> listar(){
		return productoService.findAll();

	}
	
	@GetMapping("/producto/{id}")
	public Producto detalle(@PathVariable Long id) {
		return productoService.findById(id);
	}
	
	@PostMapping("/producto/nuevo")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto insertarProducto (@RequestBody Producto producto) {
		return productoService.insertProducto(producto);
	}
	
	@DeleteMapping("/producto/borrar/{id}")
	public void borrarProducto (@RequestBody Long id) {
		productoService.borrarProducto(id);
	}
	
	@GetMapping("/producto/nombre/{nombre}")
	public List<Producto> buscarProductoPorNombre(@PathVariable String nombre){
		return productoService.buscarPorNombre(nombre);
	}
	
	@GetMapping("/producto/contiene/{nombre}")
	public List<Producto> buscarProductoPorContieneNombre(@PathVariable String nombre){
		return productoService.buscarPorNombre(nombre);
	}
	
	@PutMapping("/producto/modificar")
	public Producto modificarProducto (@RequestBody Producto producto) {
		return productoService.modificarProducto(producto);
	}

}
