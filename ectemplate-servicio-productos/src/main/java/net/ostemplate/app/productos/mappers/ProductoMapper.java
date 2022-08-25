package net.ostemplate.app.productos.mappers;

import lombok.experimental.UtilityClass;
import net.ostemplate.app.productos.models.entity.Producto;
import net.ostemplate.app.productos.models.entity.ProductoEntity;

@UtilityClass
public class ProductoMapper {

	public Producto mapToProducto() {
		return null;

	}

	public ProductoEntity mapToProductoEntityByProducto(Producto producto) {
		ProductoEntity productoEntity = new ProductoEntity();
		productoEntity.setCategoria(producto.getCategoria());
		productoEntity.setCreateAt(producto.getCreateAt());
		productoEntity.setId(producto.getId());
		productoEntity.setNombre(producto.getNombre());
		productoEntity.setPrecio(producto.getPrecio());
		productoEntity.setProductoCaracteristicas(producto.getProductoCaracteristicas());
		productoEntity.setValoracion(producto.getValoracion());
		return productoEntity;
	}
	
	public ProductoEntity mapToProduto(Producto producto) {
		
		return (ProductoEntity) ProductoEntity.builder().build();
		
	}

}
