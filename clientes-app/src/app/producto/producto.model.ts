import { ProductoCaracteristicas } from './productoCaracteristicas.model';

export class Producto{
  id!: number;
  categoria!: string;
  nombre!: string;
  precio!: number;
  valoracion!: number;
  productoCaracteristicas!: ProductoCaracteristicas
}
