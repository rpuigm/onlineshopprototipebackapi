import { HttpClientModule } from '@angular/common/http';
import { ProductoComponent } from './producto.component';
import { PRODUCTOS } from './producto.model.json';
import { Observable, of } from 'rxjs';
import { Injectable } from '@angular/core';
import { Producto } from './producto.model';
import { ProductosgridComponent } from '../productosgrid/productosgrid.component';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({providedIn: 'root'})
export class ServiceNameService {
  constructor(private httpClient: HttpClient) { }

}

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private urlEndPoint:string = 'http://localhost:8090/api/productos/lista'
  constructor(private http:HttpClient ) { }

  getProductos(): Observable<Producto[]>{
    //return of(PRODUCTOS);
    return this.http.get(this.urlEndPoint).pipe(
      map( response => response as Producto[])
    )
  }

  setProducto(productosgridComponent: ProductosgridComponent, producto: Producto){
    productosgridComponent.productos.push(producto)
    console.log('producto agregado')

  }
}
