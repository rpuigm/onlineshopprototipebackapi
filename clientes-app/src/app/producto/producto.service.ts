import { Router } from '@angular/router';
import { Observable, of, throwError } from 'rxjs';
import { Injectable } from '@angular/core';
import { Producto } from './producto.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, switchAll } from 'rxjs/operators';
import swal from 'sweetalert2';

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
  private urlEndPoint:string = 'http://localhost:8090/api/productos/producto/'

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})

  constructor(private http:HttpClient, private router:Router ) { }

  getProductos(): Observable<Producto[]>{
    //return of(PRODUCTOS);
    return this.http.get(this.urlProductosLista).pipe(
      map( response => response as Producto[]),
      catchError(e => {
        console.error(e.error.mensaje);
        swal.fire('Error al obtener los productos', e.error.mensaje, 'error');
        return throwError(e);
      })
    )
  }

  setProducto(producto: Producto): Observable<Producto> {
      console.log(producto.nombre);
      console.log(producto.productoCaracteristicas.descripcion);
      return this.http.post<Producto>(this.urlProductoNuevo, producto, {headers: this.httpHeaders});

  }

  getProductoById(id: number): Observable<Producto>{
    return this.http.get<Producto>(`${this.urlEndPoint}/${id}`).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        swal.fire('Error al obtener los productos', e.error.mensaje, 'error');
        return throwError(e);
      })
    )

  }

  subirFoto(archivo: File, id: string | Blob, descripcionImagen: string): Observable<Producto>{
    let formData = new FormData();
    formData.append("archivo", archivo);
    formData.append("id", id);
    formData.append("descripcionImagen", descripcionImagen);
    return this.http.post(`${this.urlEndPoint}/imagen`, formData).pipe(
      map((response: any)=> response.producto as Producto),
      catchError(e => {
        console.error(e.error.mensaje);
        swal.fire('No se pudo subir la foto', e.error.mensaje, 'error');
        return throwError(e);
      })

    );
  }
}
