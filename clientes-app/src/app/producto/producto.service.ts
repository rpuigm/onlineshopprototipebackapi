import { PRODUCTOS } from './producto.model.json';
import { Observable, of } from 'rxjs';
import { Injectable } from '@angular/core';
import { Producto } from './producto.model';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  constructor() { }

  getProductos(): Observable<Producto[]>{
    return of(PRODUCTOS);
  }

  setProducto(producto: Producto){
    PRODUCTOS.push(producto);
    console.log('producto agregado')

  }
}
