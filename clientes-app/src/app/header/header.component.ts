import { ProductoService } from './../producto/producto.service';
import { Producto } from './../producto/producto.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})


export class HeaderComponent{

  constructor(private productoService: ProductoService){}

  title: string = 'CHRISTMASZON'

  busqueda!: string;

  bontonBuscar(): void{

  }




}
