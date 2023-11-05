import { ProductoEspecificaciones } from './productoespecificaciones.model';
import { ImagenProducto } from './imagenproducto.model';
export class ProductoCaracteristicas{
  idProductoCaracteristicas!: number;
  descripcion!: string;
  imagenesProducto!: ImagenProducto[];
  productoEspecificaciones!: ProductoEspecificaciones[];
}
