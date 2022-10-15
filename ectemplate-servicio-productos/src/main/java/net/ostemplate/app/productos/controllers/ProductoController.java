package net.ostemplate.app.productos.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.ostemplate.app.productos.mappers.ProductoMapper;
import net.ostemplate.app.productos.models.entity.ImagenProducto;
import net.ostemplate.app.productos.models.entity.Producto;
import net.ostemplate.app.productos.models.entity.ProductoCaracteristicas;
import net.ostemplate.app.productos.models.entity.ProductoEntity;
import net.ostemplate.app.productos.models.service.FileService;
import net.ostemplate.app.productos.models.service.ImagenProductoI;
import net.ostemplate.app.productos.models.service.ProductoServiceI;

@RestController
public class ProductoController {

	private final Logger log = LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private ProductoServiceI productoService;

	@Autowired
	private ImagenProductoI imagenProductoI;
	
	@Autowired
	private FileService fileService;

	@GetMapping("/lista")
	public List<ProductoEntity> listar() {
		return productoService.findAll();

	}

	@GetMapping("/producto/{id}")
	public Producto detalle(@PathVariable Long id) {
		return productoService.findById(id);
	}

	@PostMapping(value = "/producto/nuevo")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto insertarProducto(@RequestBody Producto producto) {
		return productoService.insertProducto(ProductoMapper.mapToProductoEntityByProducto(producto));
	}

	@DeleteMapping("/producto/borrar/{id}")
	public void borrarProducto(@PathVariable Long id) {
		productoService.borrarProducto(id);
	}

	@GetMapping("/producto/nombre/{nombre}")
	public List<ProductoEntity> buscarProductoPorNombre(@PathVariable String nombre) {
		return productoService.buscarPorNombre(nombre);
	}

	@GetMapping("/producto/contiene/{nombre}")
	public List<ProductoEntity> buscarProductoPorContieneNombre(@PathVariable String nombre) {
		return productoService.buscarPorNombre(nombre);
	}

	@PutMapping("/producto/modificar")
	public Producto modificarProducto(@RequestBody Producto producto) {
		return productoService.modificarProducto(ProductoMapper.mapToProductoEntityByProducto(producto));
	}

	@PostMapping("/producto/imagen")
	public ResponseEntity<?> subidaImagen (@RequestParam ("archivo") MultipartFile archivo, @RequestParam("id") Long id
			,@RequestParam("descripcionImagen") String descripcionImagen){
		Map<String, Object> response= new HashMap<>();
		
		Producto producto = productoService.findById(id);
		
		if (!archivo.isEmpty()) {
			
			String nombreArchivo = UUID.randomUUID().toString() + "_";
					
			if(archivo.getOriginalFilename()!=null) 
					nombreArchivo+=archivo.getOriginalFilename().replace(" ", "");
			
			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
			log.info(rutaArchivo.toString());
			try {
				if (fileService.copyFile(archivo.getInputStream(), rutaArchivo)<=0)
					throw new IOException();
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen" + nombreArchivo);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			ProductoCaracteristicas productoCaracteristicas =producto.getProductoCaracteristicas();
			ImagenProducto imagenProducto = new ImagenProducto();
			List<ImagenProducto> listaImagenProducto = new ArrayList<ImagenProducto>();
			
			if (!Objects.isNull(producto.getProductoCaracteristicas()))
				productoCaracteristicas = producto.getProductoCaracteristicas();
				if (!Objects.isNull(productoCaracteristicas.getImagenesProducto()))
					listaImagenProducto = productoCaracteristicas.getImagenesProducto();
			
			imagenProducto.setNombreImagen(archivo.getOriginalFilename());
			imagenProducto.setImagen(nombreArchivo);
			imagenProducto.setDescripcionImagen(descripcionImagen);
			listaImagenProducto.add(imagenProducto);
			productoCaracteristicas.setImagenesProducto(listaImagenProducto);
			producto.setProductoCaracteristicas(productoCaracteristicas);
			
			productoService.modificarProducto(ProductoMapper
					.mapToProductoEntityByProducto(producto));
			
			response.put("producto", producto);
			response.put("mensaje", "Se ha subido la imagen: "+ nombreArchivo);
			
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}

	@DeleteMapping("producto/borrar-imagen/{imagen}")
	public void eliminarImagen(@PathVariable("imagen") String imagen) {
		imagenProductoI.borrarImagen(imagen);

	}

	@GetMapping("/producto/imagen/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto) {
		Path rutaArchivo = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
		UrlResource recurso = null;
		log.info(rutaArchivo.toString());
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!recurso.exists() && recurso.isReadable())
			throw new RuntimeException("Error - no se puedo cargar la  imagen: " + nombreFoto);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");

		return new ResponseEntity<Resource>(recurso, httpHeaders, HttpStatus.OK);

	}

}
