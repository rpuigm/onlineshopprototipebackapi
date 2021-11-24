import { ProductoCantidad } from './productoCantidad.model';
export class Cesta{

  id!: number;
  idUsuario!: number;
  activa!: boolean;
  productoCantidad!: ProductoCantidad[];

}
