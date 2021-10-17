import { ProductoService } from './../producto/producto.service';
import { Component, OnInit } from '@angular/core';
import { Producto } from '../producto/producto.model';

@Component({
  selector: 'app-altaproducto',
  templateUrl: './altaproducto.component.html',
  styleUrls: ['./altaproducto.component.css']
})
export class AltaproductoComponent implements OnInit {

  producto!: Producto;

  constructor(productoService: ProductoService) { }

  ngOnInit(): void {
  }


}
