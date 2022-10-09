package net.ostemplate.app.productos.models.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public interface FileService {


	public long copyFile (InputStream inputStream, Path path) throws IOException;
}
