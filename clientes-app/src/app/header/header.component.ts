import { PersonaServices } from './../persona/persona.service';
import { ProductoService } from './../producto/producto.service';
import { Producto } from './../producto/producto.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import swal from 'sweetalert2'

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})


export class HeaderComponent{

  constructor(private personaServices: PersonaServices, private productoService: ProductoService, private router: Router){}


  logout(): void {
    let username = this.personaServices.usuario.username;
    swal.fire('Logout', `Hola ${username}, has cerrado sesión con éxito!`, 'success');
    this.personaServices.logout();
    this.router.navigate(['/login']);
  }

  title: string = 'CHRISTMASZON'

  busqueda!: string;

  bontonBuscar(): void{

  }

  irALogin(){
    this.router.navigate(['login']);
  }

  getUsuario(){
    return this.personaServices.usuario.nombre;
  }

  estaAuthenticado(): boolean{
    let variable=this.personaServices.isAuthenticated();
    console.log('autenticado '+variable)
    return variable;
  }

  tienePermisos(role: string): boolean{
    return this.personaServices.hasRole(role);
  }


}
