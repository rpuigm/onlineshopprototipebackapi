package net.ostemplate.app.productos.models.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public long copyFile(InputStream inputStream, Path path) throws IOException {
		return Files.copy(inputStream, path);
	}

}
