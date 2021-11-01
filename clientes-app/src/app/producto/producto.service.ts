import { Observable, of } from 'rxjs';
import { Injectable } from '@angular/core';
import { Producto } from './producto.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({providedIn: 'root'})
export class ServiceNameService {
  constructor(private httpClient: HttpClient) { }

}

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private urlProductosLista:string = 'http://localhost:8090/api/productos/lista'
  private urlProductoNuevo:string = 'http://localhost:8090/api/productos/producto/nuevo'

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})

  constructor(private http:HttpClient ) { }

  getProductos(): Observable<Producto[]>{
    //return of(PRODUCTOS);
    return this.http.get(this.urlProductosLista).pipe(
      map( response => response as Producto[])
    )
  }

  setProducto(producto: Producto): Observable<Producto> {
      console.log(producto.nombre);
      return this.http.post<Producto>(this.urlProductoNuevo, producto, {headers: this.httpHeaders});


  }
}
