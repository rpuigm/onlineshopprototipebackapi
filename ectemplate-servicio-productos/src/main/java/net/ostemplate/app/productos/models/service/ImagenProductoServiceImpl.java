package net.ostemplate.app.productos.models.service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ostemplate.app.productos.models.dao.ImagenProductoDao;
import net.ostemplate.app.productos.models.entity.ImagenProducto;

@Service
public class ImagenProductoServiceImpl implements ImagenProductoI {
	
	@Autowired
	private ImagenProductoDao imagenProductoDao;
	
	@Override
	@Transactional
	public void borrarImagen (String imagen) {
		Path rutaFotoAnterior = Paths.get("uploads").resolve(imagen).toAbsolutePath();
		File archivoFotoAnterior = rutaFotoAnterior.toFile();
		if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
			archivoFotoAnterior.delete();
		}
		imagenProductoDao.deleteByImagen(imagen);
		
	}

}
