package net.ostemplate.app.productos.mappers;

import lombok.experimental.UtilityClass;
import net.ostemplate.app.productos.models.entity.ProductoCaracteristicas;

@UtilityClass	
public class ProductFeaturesMapper {

	ProductoCaracteristicas mapToProductoCaracteristicas() {
		return ProductoCaracteristicas.builder()
				.build();
		
	}
}
