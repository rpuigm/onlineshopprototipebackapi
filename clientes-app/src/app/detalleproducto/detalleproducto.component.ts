import { ProductoService } from './../producto/producto.service';
import { Component, OnInit } from '@angular/core';
import { Producto } from '../producto/producto.model';

@Component({
  selector: 'app-detalleproducto',
  templateUrl: './detalleproducto.component.html',
  styleUrls: ['./detalleproducto.component.css']
})
export class DetalleproductoComponent implements OnInit {

  producto: Producto;

  constructor(private productoService: ProductoService) { }

  ngOnInit(): void {
  }

}
