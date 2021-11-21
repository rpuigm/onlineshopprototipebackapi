import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable, Input } from '@angular/core';
import { Empleado } from './empleado.model';
import { Router } from '@angular/router';
import { Producto } from '../producto/producto.model';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService{

  private urlEmpleado=""

  constructor(private httpClient:HttpClient, private router: Router){}



}
