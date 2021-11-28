import { ProductoCantidad } from './productoCantidad.model';
import { ProductoService } from './../producto/producto.service';
import { PersonaServices } from './../persona/persona.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Injectable, OnInit } from '@angular/core';
import { Cesta } from './cesta.model';
import { catchError, map } from 'rxjs/operators';
import swal from 'sweetalert2';

@Injectable({
  providedIn: 'root',
})
export class CestaService implements OnInit {
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  private urlRecuperaCesta: string =
    'http://localhost:8090/api/productos/cesta/recupera-cesta';
  private urlIncluye: string =
    'http://localhost:8090/api/productos/cesta/actualiza-cesta';

  constructor(
    private httpClient: HttpClient,
    private personaServices: PersonaServices,
    private productoService: ProductoService
  ) {}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  recuperarCesta(idUsuario: number): Observable<Cesta> {
    return this.httpClient
      .get<Cesta>(`${this.urlRecuperaCesta}/${idUsuario}`, {
        headers: this.productoService.agregarAuthorizationHeader(),
      })
      .pipe(
        catchError((e) => {
          console.error(e.error.mensaje);
          swal.fire('No hay elementos en la cesta', e.error.mensaje, 'info');
          return throwError(e);
        })
      );
  }

  recuperarCestaSinLanzarError(idUsuario: number): Observable<Cesta> {
    return this.httpClient
      .get<Cesta>(`${this.urlRecuperaCesta}/${idUsuario}`, {
        headers: this.productoService.agregarAuthorizationHeader(),
      })
  }

  agregarProductoACesta(
    idUsuario: number,
    idProducto: number
  ): Observable<Cesta> {
    let cesta = new Cesta();
    this.recuperarCesta(idUsuario).subscribe(
      (response) =>{
        if (response!=null){
          cesta=response
        }

      }

      );
    let productoCantidad = new ProductoCantidad();

    productoCantidad.idProducto = idProducto;
    productoCantidad.cantidad = 1;
    cesta.idUsuario=idUsuario
    cesta.productoCantidad.push(productoCantidad);
    let httpHeaders = new HttpHeaders();
    let token = this.personaServices.token;
    console.log(cesta.productoCantidad[0].cantidad)

    return this.httpClient
      .post<Cesta>(this.urlIncluye, cesta, {
        headers: this.productoService.agregarAuthorizationHeader(),
      })
      .pipe(
        catchError((e) => {
          console.error(e.error.mensaje);
          swal.fire('No se guardó el producto', e.error.mensaje, 'error');
          return throwError(e);
        })

      );
  }

  incluirEnCesta (cesta: Cesta): Observable<Cesta>{
    console.log('llega' + cesta.productoCantidad[0].idProducto)
    return this.httpClient
      .post<Cesta>(this.urlIncluye, cesta, {
        headers: this.productoService.agregarAuthorizationHeader(),
      })
      .pipe(
        catchError((e) => {
          console.error(e.error.mensaje);
          swal.fire('No se guardó el producto', e.error.mensaje, 'error');
          return throwError(e);
        })

      );
  }
}
