import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import swal from 'sweetalert2';
import { Tienda } from '../configuracion/tienda.model';
import { PersonaServices } from './../persona/persona.service';
import { Producto } from './producto.model';

@Injectable({ providedIn: 'root' })
export class ServiceNameService {
  constructor(private httpClient: HttpClient) {}
}

@Injectable({
  providedIn: 'root',
})
export class ProductoService {
  
 // private urlRoot: string = '//psychic-succotash-5x944xv45qjh4wxr-8090.app.github.dev'
  private urlRoot= environment.backEndURL;
  private urlProductosLista: string = this.urlRoot + '/api/productos/lista';
  private urlProductoNuevo: string = this.urlRoot + '/api/productos/producto/nuevo';
  private urlEndPoint: string = this.urlRoot + '/api/productos/producto';
  private urlEliminarProducto: string = this.urlRoot + '/api/productos/producto/borrar';
  private urlEliminarImagen: string = this.urlRoot + '/api/productos/producto/borrar-imagen';
  private urlCambiarNombre: string = this.urlRoot + '/api/productos/tienda/cambia-tienda';
  private urlNombre: string = this.urlRoot + '/api/productos/tienda/nombre';

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'});

  busqueda: string;



  constructor(
    private http: HttpClient,
    private router: Router,
    private personaServices: PersonaServices
  ) {}

  public agregarAuthorizationHeader() {
    let token = this.personaServices.token;
    if (token != null) {
      return this.httpHeaders.append('Authorization', 'Bearer ' + token);
    }
    return this.httpHeaders;
  }

  getProductos(): Observable<Producto[]> {
    //return of(PRODUCTOS);
    return this.http.get(this.urlProductosLista).pipe(
      map((response) => response as Producto[]),
      catchError((e) => {
        console.error(e.error.mensaje);
        swal.fire('Error al obtener los productos', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  setProducto(producto: Producto): Observable<Producto> {
    console.log(producto.nombre);
    console.log(producto.productoCaracteristicas.descripcion);
    return this.http
      .post<Producto>(this.urlProductoNuevo, producto, {
        headers: this.agregarAuthorizationHeader(),
      })
      .pipe(
        catchError((e) => {
          swal.fire('Error al guardar los producto', e.error.mensaje, 'error');
          this.isNoAutorizado(e);
          console.error(e.error.mensaje);
          return throwError(e);
        })
      );
  }

  getProductoById(id: number): Observable<Producto> {
    return this.http.get<Producto>(`${this.urlEndPoint}/${id}`).pipe(
      catchError((e) => {
        console.error(e.error.mensaje);
        swal.fire('Error al obtener los productos', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  subirFoto(
    archivo: File,
    id: string | Blob,
    descripcionImagen: string
  ): Observable<Producto> {
    let formData = new FormData();
    formData.append('archivo', archivo);
    formData.append('id', id);
    formData.append('descripcionImagen', descripcionImagen);

    let httpHeaders = new HttpHeaders();
    let token = this.personaServices.token;
    if (token != null) {
      httpHeaders = httpHeaders.append('Authorization', 'Bearer ' + token);
    }

    return this.http
      .post(`${this.urlEndPoint}/imagen`, formData, {
        headers: httpHeaders,
      })
      .pipe(
        map((response: any) => response.producto as Producto),
        catchError((e) => {
          console.error(e.error.mensaje);
          swal.fire('No se pudo subir la foto', e.error.mensaje, 'error');
          return throwError(e);
        })
      );
  }


  private isNoAutorizado(e: { status: number }): boolean {
    if (e.status == 401) {
      if (this.personaServices.isAuthenticated()) {
        this.personaServices.logout();
      }
      this.router.navigate(['/login']);
      return true;
    }

    if (e.status == 403) {
      swal.fire('Error', 'Acceso Denegaod', 'warning');
      return true;
    }

    return false;
  }

  setFiltro(busqueda: string) {
    this.busqueda = busqueda;
  }

  getFiltro(busqueda: string) {
    return this.busqueda;
  }

  eliminarProducto(id: number): Observable<Producto> {
    return this.http
      .delete<Producto>(`${this.urlEliminarProducto}/${id}`, {
        headers: this.agregarAuthorizationHeader(),
      })
      .pipe(
        catchError((e) => {
          console.error(e.error.mensaje);
          swal.fire('No se pudo borra el producto', e.error.mensaje, 'error');
          return throwError(e);
        })
      );
  }
  eliminarImagen(imagen: string): Observable<any> {
    console.log(this.urlEliminarImagen+'/'+imagen)
    return this.http
      .delete<any>(`${this.urlEliminarImagen}/${imagen}`, {
        headers: this.agregarAuthorizationHeader(),
      })
      .pipe(
        catchError((e) => {
          console.error(e.error.mensaje);
          swal.fire('No se pudo borra el producto', e.error.mensaje, 'error');
          return throwError(e);
        })
      );
  }

  setNombreTienda(tienda: Tienda): Observable<Tienda>{
    return this.http
      .post<Tienda>(this.urlCambiarNombre, tienda, {
        headers: this.agregarAuthorizationHeader(),
      })
      .pipe(
        catchError((e) => {
          swal.fire('Error al guardar el nombre de la tienda', e.error.mensaje, 'error');
          this.isNoAutorizado(e);
          console.error(e.error.mensaje);
          return throwError(e);
        })
      );



  }
  getNombreTienda(): Observable<Tienda>{
    return this.http
      .get<Tienda>(`${this.urlNombre}`, {
        headers: this.httpHeaders,
      })
      .pipe(

      );

  }
}
