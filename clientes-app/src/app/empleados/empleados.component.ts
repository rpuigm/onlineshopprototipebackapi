import { Component, Input, OnInit } from '@angular/core';
import { Empleado } from './empleado.model';

@Component({
  selector: 'app-empleados',
  templateUrl: './empleados.component.html',
  styleUrls: ['./empleados.component.css']
})
export class EmpleadosComponent implements OnInit {

  @Input() empleado: Empleado;
  constructor() { }

  ngOnInit(): void {
  }

}
