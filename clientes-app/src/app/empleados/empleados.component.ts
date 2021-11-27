import swal from 'sweetalert2';
import { Router } from '@angular/router';
import { Usuario } from './../login/usuario.model';
import { EmpleadoService } from './empleado.service';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-empleados',
  templateUrl: './empleados.component.html',
  styleUrls: ['./empleados.component.css']
})
export class EmpleadosComponent implements OnInit {


  usuario: Usuario;

  constructor(private empleadoService: EmpleadoService, private router:Router) {
  }

  ngOnInit(): void {
    this.setUsuario(new Usuario())
    this.empleadoService.obtenerUsuarioPorUsername().subscribe(
      usu => this.usuario = usu
    );
  }

  guaradarEmpleado(): void{
    console.log('entra' + this.usuario)
    this.empleadoService.guardarEmpleado(this.usuario).subscribe(
      response => {this.usuario = response}
    );
    swal.fire("Guardado!!", "Se han guardado los cambios", "success")


  }

  getUsuario(): Usuario{
    return this.usuario;
  }

  setUsuario(usuario: Usuario){
    this.usuario= usuario;
  }

  setUsuarioPass(event: Event){
    this.usuario.password=(<HTMLInputElement>event.target).value;
  }

}
