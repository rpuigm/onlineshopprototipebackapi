import { ProductoEspecificaciones } from './productoEspecificaciones.model';
import { ImagenProducto } from './imagenproducto.model';
export class ProductoCaracteristicas{
  idProductoCaracteristicas!: number;
  descripcion!: string;
  imagenesProducto!: ImagenProducto[];
  productoEspecificaciones!: ProductoEspecificaciones[];
}
