import { ProductoService } from './../producto/producto.service';
import { PersonaServices } from './../persona/persona.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Injectable, OnInit } from '@angular/core';
import { Cesta } from './cesta.model';
import { catchError, map } from 'rxjs/operators';
import swal from 'sweetalert2';
import { ThisReceiver } from '@angular/compiler';

@Injectable({
  providedIn: "root"
})
export class CestaService implements OnInit{

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  private urlRecuperaCesta: string="http://localhost:8090/api/productos/recupera-cesta";
  private urlIncluye: string="http://localhost:8090/api/productos/incluye-cesta";

  constructor(private httpClient: HttpClient,
    private personaServices: PersonaServices,
    private productoService: ProductoService){}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  recuperarCesta(id: number): Observable<Cesta>{
    return this.httpClient.get<Cesta>(`${this.urlRecuperaCesta}/${id}`, {
      headers: this.productoService.agregarAuthorizationHeader(),
    }).pipe(
        catchError((e) => {
        console.error(e.error.mensaje);
        swal.fire('Error al obtener la cesta', e.error.mensaje, 'error');
        return throwError(e);
    }));
  }

  agregarProductoACesta(idUsuario: number, idProducto:number): Observable<Cesta>{
    console.log('cesta2'+ this.personaServices.usuario.id)
    let formData = new FormData();
    formData.append('idUsuario', this.personaServices.usuario.id.toString());
    formData.append('idProducto', idProducto.toString());

    let httpHeaders = new HttpHeaders();
    let token = this.personaServices.token;
    if (token != null) {
      httpHeaders = httpHeaders.append('Authorization', 'Bearer ' + token);
    }

    return this.httpClient
      .post<Cesta>(`${this.urlIncluye}`, formData, {
        headers: this.productoService.agregarAuthorizationHeader(),
      })
      .pipe(
        catchError((e) => {
          console.error(e.error.mensaje);
          swal.fire('No se guardar en cesta', e.error.mensaje, 'error');
          return throwError(e);
        })
      );
  }


}
