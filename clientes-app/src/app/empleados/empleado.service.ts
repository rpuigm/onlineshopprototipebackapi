import { catchError } from 'rxjs/operators';
import { PersonaServices } from './../persona/persona.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Injectable, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../login/usuario.model';
import { ProductoService } from '../producto/producto.service';
import swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService{


  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  private urlUsuarioActualizar="http://localhost:8090/api/personas/actualiza-usuario"
  private urlUsuarioPorUsername="http://localhost:8090/api/personas/usuarios/search/buscar-username?username="

  constructor(private httpClient:HttpClient, private router: Router, private productoService: ProductoService, private personaServices: PersonaServices){}


  guardarEmpleado(usuario: Usuario): Observable<any>{
    console.log("pasa por aquí" + usuario.apellidos)
    return this.httpClient.put<any>(this.urlUsuarioActualizar, usuario,
     {headers: this.productoService.agregarAuthorizationHeader()})

  }

  obtenerUsuarioPorUsername(): Observable<Usuario>{
    console.log("usuario:"+this.personaServices.usuario.username)
    return this.httpClient.get<Usuario>(this.urlUsuarioPorUsername + this.personaServices.usuario.username,
      {headers: this.productoService.agregarAuthorizationHeader()})
  }


}
