import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Usuario } from '../login/usuario.model';
import { ProductoService } from '../producto/producto.service';
import { PersonaServices } from './../persona/persona.service';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService{


  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  private urlUsuarioActualizar="http://https://psychic-succotash-5x944xv45qjh4wxr-8090.app.github.dev/api/personas/actualiza-usuario"
  private urlUsuarioPorUsername="http://https://psychic-succotash-5x944xv45qjh4wxr-8090.app.github.dev/api/personas/usuarios/search/buscar-username?username="

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
