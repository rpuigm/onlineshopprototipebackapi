import { Router } from '@angular/router';
import { PersonaServices } from './../persona/persona.service';
import { Usuario } from './usuario.model';
import { Component, Input, OnInit } from '@angular/core';
import { Persona } from '../persona/persona.model';
import swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  titulo='Acceso'

  usuario: Usuario;

  constructor(private personaServices: PersonaServices, private router: Router) {
    this.usuario=new Usuario();
  }

  ngOnInit(): void {
    if (this.personaServices.isAuthenticated()) {
      swal.fire('Login', `Hola ${this.personaServices.usuario.username} ya estás autenticado!`, 'info');
      this.router.navigate(['/productosgrid']);
    }
  }

  irARegistrar(){
    this.router.navigate(['altapersona']);
  }

  login(): void{
    console.log("usuario:"+this.usuario);
    if(this.usuario.username== null || this.usuario.password==null){
        swal.fire('Error login', 'usuario o contraseña vacia', 'error')
    }
    this.personaServices.login(this.usuario).subscribe(response =>
      {
        this.personaServices.guardarUsuario(response.access_token);
        this.personaServices.guardarToken(response.access_token);
        let payload= JSON.parse(atob(response.access_token.split(".")[1]));
        console.log(payload);
        this.router.navigate(['productosgrid']);
      }, error =>{
        if (error.status==400){
          swal.fire('Error login', 'usuario o contraseña incorrectos', 'error')
        }

      }

      );
  }
}
