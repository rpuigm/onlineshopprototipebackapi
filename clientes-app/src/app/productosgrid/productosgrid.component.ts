import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-productosgrid',
  templateUrl: './productosgrid.component.html',
  styleUrls: ['./productosgrid.component.css']
})
export class ProductosgridComponent implements OnInit {

  elemento: string[] = ['Arboles', 'Decoración Arbol', 'Belén', 'Ciudad de Dickens', 'Especiales'];

  constructor() { }

  ngOnInit(): void {
  }




}
