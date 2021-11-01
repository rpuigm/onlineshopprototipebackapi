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

  productoAlta!: Producto;

  private prueba: string;
  deshabilitar=false;

  private mensaje='no se agrego';
  private titulo ='';

  constructor(private productoService: ProductoService,
    private router: Router) { }



  ngOnInit():void {
    this.prueba= '45345';
  }

  getPrueba(): string{
    return this.prueba;
  }

  agregarProducto(): void{

    console.log(this.productoAlta.nombre);
    this.productoService.setProducto(this.productoAlta).subscribe(
      response => this.router.navigate(['/productosgrid'])
    );
    console.log('sale');

  }

  getTitulo(){
    return this.titulo;
  }

  getPruebaMensaje(){
    return this.mensaje;
  }
  setPrueba(){
    this.mensaje='agregado';
  }

  modificarTitulo(event: Event){
    this.titulo = (<HTMLInputElement>event.target).value;
  }


}
