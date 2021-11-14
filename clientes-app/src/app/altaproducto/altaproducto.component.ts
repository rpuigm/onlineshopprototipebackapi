import { ProductoCaracteristicas } from './../producto/productoCaracteristicas.model';
import { Observable } from 'rxjs';
import { ProductoEspecificaciones } from '../producto/productoEspecificaciones.model';
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
  private listaProductoEspecificaciones: ProductoEspecificaciones[];
  private productoEspecificaciones: ProductoEspecificaciones;
  private productoCaracteristicas: ProductoCaracteristicas;


  constructor(private productoService: ProductoService,
    private router: Router) { }

  ngOnInit():void {
    this.producto = new Producto();
    this.listaProductoEspecificaciones = new Array<ProductoEspecificaciones>();
    this.productoEspecificaciones = new ProductoEspecificaciones();
    this.productoCaracteristicas = new ProductoCaracteristicas();
    this.producto.productoCaracteristicas=this.productoCaracteristicas;

  }

  agregarProducto(): void{
    this.productoService.setProducto(this.producto).subscribe(
      response => this.router.navigate(['/item/'+ response.id])
    );
    console.log('sale');

  }

  getProducto(){
    return this.producto;
  }
  getListaProductoEspecificaciones(){
    return this.listaProductoEspecificaciones;
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

  setProductoCaracteristicasDescripcion(event: Event){
    this.producto.productoCaracteristicas.descripcion = (<HTMLInputElement>event.target).value;
  }

  setProductoClaveEspecificacion(event: Event){
    this.productoEspecificaciones.claveEspecificacion=(<HTMLInputElement>event.target).value;
  }

  setProductoEspecificacion(event: Event){
    this.productoEspecificaciones.descripcionEspecificacion=(<HTMLInputElement>event.target).value;
  }

  agregarEspecificacion():void {
    this.listaProductoEspecificaciones.push(this.productoEspecificaciones);
    this.producto.productoCaracteristicas.productoEspecificaciones= this.listaProductoEspecificaciones;
    console.log(this.producto.productoCaracteristicas.productoEspecificaciones.length);
    this.producto.productoCaracteristicas = this.productoCaracteristicas;
    this.productoEspecificaciones= new ProductoEspecificaciones();
  }
}
