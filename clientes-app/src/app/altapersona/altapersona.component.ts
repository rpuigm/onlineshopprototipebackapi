import { EmpleadoService } from './../empleados/empleado.service';
import { AltaPersonaService } from './altapersona.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { PersonaServices } from './../persona/persona.service';
import { Component, OnInit } from '@angular/core';
import { Usuario } from '../login/usuario.model';

@Component({
  selector: 'app-altapersona',
  templateUrl: './altapersona.component.html',
  styleUrls: ['./altapersona.component.css'],
})
export class AltapersonaComponent implements OnInit {
  usuario: Usuario;

  constructor(
    private altaPersonaService: AltaPersonaService,
    private router: Router,
  ) {}

  ngOnInit(): void {
    this.setUsuario(new Usuario())

  }

  altaCliente(): void {
      console.log('entra en alta')
      this.altaPersonaService.altaCliente(this.usuario).subscribe((r) => {});
      this.router.navigate(['login']);

  }

  getUsuario(): Usuario {
    return this.usuario;
  }

  setUsuario(usuario: Usuario) {
    this.usuario = usuario;
  }

  setUsuarioPass(event: Event) {
    this.usuario.password = (<HTMLInputElement>event.target).value;
  }
}
