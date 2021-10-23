import { ProductoService } from './../producto/producto.service';
import { Component, OnInit } from '@angular/core';
import { Producto } from '../producto/producto.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-altaproducto',
  templateUrl: './altaproducto.component.html',
  styleUrls: ['./altaproducto.component.css']
})
export class AltaproductoComponent implements OnInit {

  producto: Producto;
  titulo: string;
  precio: number;

  constructor(private productoService: ProductoService) { }

  ngOnInit(): void {
  }


  agregarProducto(){
    console.log('entra en agregar');

  }
}
