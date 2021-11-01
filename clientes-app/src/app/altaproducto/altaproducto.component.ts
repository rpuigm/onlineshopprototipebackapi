import { ProductoService } from './../producto/producto.service';
import { Component, Input, OnInit, Output } from '@angular/core';
import { Producto } from '../producto/producto.model';
import { Router } from '@angular/router'

@Component({
  selector: 'app-altaproducto',
  templateUrl: './altaproducto.component.html',
  styleUrls: ['./altaproducto.component.css']
})
export class AltaproductoComponent implements OnInit {

  private producto: Producto;

  constructor(private productoService: ProductoService,
    private router: Router) { }

  ngOnInit():void {
    this.producto = new Producto();
  }

  agregarProducto(): void{

    this.productoService.setProducto(this.producto).subscribe(
      response => this.router.navigate(['/productosgrid'])
    );
    console.log('sale');

  }

  setProductoNombre (event: Event){
    this.producto.nombre =(<HTMLInputElement>event.target).value;
  }
  setProductoCategoria (event: Event){
    this.producto.categoria =(<HTMLInputElement>event.target).value;
  }
  setProductoPrecio (event: Event){
    this.producto.precio =Number((<HTMLInputElement>event.target).value);
  }



}
