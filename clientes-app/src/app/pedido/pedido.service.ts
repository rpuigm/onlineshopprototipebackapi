import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import swal from 'sweetalert2';
import { PersonaServices } from '../persona/persona.service';
import { ProductoService } from './../producto/producto.service';
import { Pedido } from './pedido.model';

@Injectable({
  providedIn: 'root',
})
export class PedidoService {
  private urlProductosLista: string =
    'http://localhost:8090/api/productos/lista';
  private urlActualizaPedido: string =
    'http://localhost:8090/api/productos/pedidos/actualiza-pedido';
  private urlRecuperaPedido: string =
    'http://localhost:8090/api/productos/pedidos/recupera-pedido';
  private urlRecuperaPedidoIdUsuario: string =
    'http://localhost:8090/api/productos/pedidos/recupera-pedidos-usuario';
  private urlRecuperaPedidos: string =
    'http://localhost:8090/api/productos/pedidos/lista';
  private urlEliminaPedido: string =
    'http://localhost:8090/api/productos/pedidos/borra-pedido';

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(
    private http: HttpClient,
    private router: Router,
    private personaServices: PersonaServices,
    private productoService: ProductoService
  ) {}

  setPedido(pedido: Pedido): Observable<Pedido> {
    return this.http
      .post<Pedido>(this.urlActualizaPedido, pedido, {
        headers: this.productoService.agregarAuthorizationHeader(),
      })
      .pipe(
        catchError((e) => {
          swal.fire('Error al guardar los producto', e.error.mensaje, 'error');
          console.error(e.error.mensaje);
          return throwError(e);
        })
      );
  }

  getPedidoById(id: number): Observable<Pedido> {
    return this.http.get<Pedido>(`${this.urlRecuperaPedido}/${id}`, {
      headers: this.productoService.agregarAuthorizationHeader()
    }).pipe(
      catchError((e) => {
        console.error(e.error.mensaje);
        swal.fire('Error al obtener los pedidos', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  getPedidosByIdusuario(idUsuario: number): Observable<Pedido[]> {
    return this.http.get<Pedido[]>(`${this.urlRecuperaPedidoIdUsuario}/${idUsuario}`, {
      headers: this.productoService.agregarAuthorizationHeader()
    }).pipe(
      catchError((e) => {
        console.error(e.error.mensaje);
        swal.fire('Error al obtener los pedidos', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  getPedidos(): Observable<Pedido[]> {
    return this.http.get<Pedido[]>(`${this.urlRecuperaPedidos}`, {
      headers: this.productoService.agregarAuthorizationHeader()
    }).pipe(
      catchError((e) => {
        console.error(e.error.mensaje);
        swal.fire('Error al obtener los pedidos', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  eliminarPedido(id: number){
    return this.http.delete(`${this.urlEliminaPedido}/${id}`, {
      headers: this.productoService.agregarAuthorizationHeader()
    }).pipe(
      catchError((e) => {
        console.error(e.error.mensaje);
        swal.fire('Error al obtener los pedidos', e.error.mensaje, 'error');
        return throwError(e);
      })
    );

  }

}
