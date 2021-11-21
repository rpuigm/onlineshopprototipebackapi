import { Usuario } from './../login/usuario.model';
import { EmpleadoService } from './empleado.service';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-empleados',
  templateUrl: './empleados.component.html',
  styleUrls: ['./empleados.component.css']
})
export class EmpleadosComponent implements OnInit {


  usuario!: Usuario;

  constructor(private empleadoService: EmpleadoService) {
  }

  ngOnInit(): void {
    this.empleadoService.obtenerUsuarioPorUsername().subscribe(
      usu => this.usuario = usu
    );
  }

  guaradarEmpleado(): void{
    console.log('entra' + this.usuario)
    this.empleadoService.guardarEmpleado(this.usuario);


  }

}
