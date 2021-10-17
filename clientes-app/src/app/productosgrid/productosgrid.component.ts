import { Producto } from './../producto/producto.model';
import { ProductoService } from './../producto/producto.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-productosgrid',
  templateUrl: './productosgrid.component.html',
  styleUrls: ['./productosgrid.component.css']
})
export class ProductosgridComponent implements OnInit {

  productos: Producto[];
  elemento: string[] = ['Arboles', 'Decoración Arbol', 'Belén', 'Ciudad de Dickens', 'Especiales'];

  constructor(private productoService: ProductoService) { }

  ngOnInit(): void {
    this.productoService.getProductos().subscribe(
      productos => this.productos= productos
    )
    console.log(this.productos[3].precio)

  }




}
