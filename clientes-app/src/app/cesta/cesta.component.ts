import { ProductoService } from './../producto/producto.service';
import { PersonaServices } from './../persona/persona.service';
import { CestaService } from './cesta.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Cesta } from './cesta.model';
import { Producto } from '../producto/producto.model';

@Component({
  selector: 'app-cesta',
  templateUrl: './cesta.component.html',
  styleUrls: ['./cesta.component.css'],
})
export class CestaComponent implements OnInit {
  cesta: Cesta;
  producto!: Producto;
  productos!: Producto[];

  numero!: number;

  constructor(
    private activatedRoute: ActivatedRoute,
    private cestaService: CestaService,
    private personaService: PersonaServices,
    private productoService: ProductoService
  ) {}

  ngOnInit(): void {
    this.cesta = new Cesta();

    this.setCesta()

  }

  setCesta(){
    this.cestaService
      .recuperarCesta(this.personaService.usuario.id)
      .subscribe((cesta) => {
        this.cesta = cesta;
        console.log('numero de productos' + cesta?.productoCantidad.length);
        this.productos = [];
        this.cesta.productoCantidad.forEach((elemento) => {
          let item = new Producto();
          item = this.recuperaProducto(elemento.idProducto)
          console.log('item'+item.nombre)
          this.productos.push(item);
        });
        console.log('tamaño' + this.productos.length);
      });

  }

  recuperaProducto(idProducto: number): Producto {
    this.producto = new Producto();
    if (idProducto) {
      this.productoService.getProductoById(idProducto).subscribe((producto) => {
        this.producto = producto;
        console.log(this.producto.nombre);
      });
    }
    return this.producto;
  }

  getProductoNumero(): number {
    return this.productos.length;
  }

  getProductos(): Producto[] {
    return this.productos;
  }

  getNombrePrimerProducto(): string{
    return this.productos[1].nombre
  }
}
