import { ProductoComponent } from './producto.component';
import { PRODUCTOS } from './producto.model.json';
import { Observable, of } from 'rxjs';
import { Injectable } from '@angular/core';
import { Producto } from './producto.model';
import { ProductosgridComponent } from '../productosgrid/productosgrid.component';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  constructor() { }

  getProductos(): Observable<Producto[]>{
    return of(PRODUCTOS);
  }

  setProducto(productosgridComponent: ProductosgridComponent, producto: Producto){
    productosgridComponent.productos.push(producto)
    console.log('producto agregado')

  }
}
