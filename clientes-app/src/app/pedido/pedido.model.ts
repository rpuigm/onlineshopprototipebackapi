import { ProductosPedido } from './ProductosPedido';
import { DireccionPedido } from './../direccion-pedido/direccion-pedido.model';
export class Pedido {
  id!: number;
  idUsuario!: number;
  estado!: string;
  total!: number;
  listaProcutosPedido!: ProductosPedido[];
  direccionPedido!: DireccionPedido;
}
