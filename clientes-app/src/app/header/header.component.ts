import { PersonaServices } from './../persona/persona.service';
import { ProductoService } from './../producto/producto.service';
import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import swal from 'sweetalert2'
import { Tienda } from '../configuracion/tienda.model';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})


export class HeaderComponent implements OnInit{

  constructor(private personaServices: PersonaServices,
    private productoService: ProductoService,
    private router: Router,
    ){}

  ngOnInit(): void {
    this.tienda=new Tienda()
    this.productoService.getNombreTienda().subscribe(
      (r)=>{this.tienda=r}
    )
  }




  logout(): void {
    let username = this.personaServices.usuario.username;
    swal.fire('Logout', `Hola ${username}, has cerrado sesión con éxito!`, 'success');
    this.personaServices.logout();
    this.router.navigate(['/login']);
  }

  title: string ;

  busqueda: string;

  tienda: Tienda;



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


  setNombreTienda(event: Event){
    this.title;
  }

  buscar(){
    this.productoService.setFiltro(this.busqueda)
  }

  getNombreTienda(){
    this.tienda=new Tienda();
    this.productoService.getNombreTienda().subscribe(
      res => this.tienda=res
    )
  }

}
