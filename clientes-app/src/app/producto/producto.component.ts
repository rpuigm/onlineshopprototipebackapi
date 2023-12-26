import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cesta } from '../cesta/cesta.model';
import { CestaService } from './../cesta/cesta.service';
import { ProductoCantidad } from './../cesta/productoCantidad.model';
import { PersonaServices } from './../persona/persona.service';
import { Producto } from './producto.model';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css'],
})
export class ProductoComponent implements OnInit {
  @Input() elemento: string;
  @Input() producto: Producto;

  imagenEscaparate: string;

  private idUsuario: number;
  private cesta: Cesta;
  private listaProductoCantidad: ProductoCantidad[];

  constructor(
    private router: Router,
    private cestaService: CestaService,
    private personaServices: PersonaServices
  ) {}

  ngOnInit(): void {
    this.imagenEscaparate = '../assets/images/christmas-tree-pieces.jpg';
    this.getImagenEscaparate();
    this.idUsuario = this.personaServices.usuario.id;
  }

  getImagenEscaparate(): void {
    if (this.producto?.productoCaracteristicas?.imagenesProducto?.length > 0)
      this.imagenEscaparate =
        'http://https://psychic-succotash-5x944xv45qjh4wxr-8090.app.github.dev/api/productos/producto/imagen/' +
        this.producto.productoCaracteristicas.imagenesProducto[0].imagen;
  }

  irADetalleProducto() {
    this.router.navigate(['/detalleproducto/' + this.producto.id]);
  }

  agregarEnCesta_old() {
    console.log('cesta ' + this.personaServices.usuario.id);
    console.log(this.personaServices.usuario.id);
    this.cestaService
      .agregarProductoACesta(this.personaServices.usuario.id, this.producto.id)
      .subscribe((res) => {
        console.log('respuesta' + res.idUsuario);
      });
    this.router.navigate(['/cesta']);
  }

  agregarEnCesta() {
    this.cestaService.recuperarCesta(this.idUsuario).subscribe((respuesta) => {
      this.cesta = respuesta;
      if (respuesta == null) {
        this.cesta = new Cesta();
        this.cesta.idUsuario = this.idUsuario;
      }

      if (this.cesta.productoCantidad == null) {
        this.cesta.productoCantidad = new Array<ProductoCantidad>();
      } else {
        this.listaProductoCantidad = this.cesta.productoCantidad;
      }

      let productoCantidad: ProductoCantidad = new ProductoCantidad();
      productoCantidad.idProducto = this.producto.id;
      productoCantidad.cantidad = 1;

      this.cesta.productoCantidad.push(productoCantidad);
      console.log(this.cesta.productoCantidad.length);
      this.cestaService.incluirEnCesta(this.cesta).subscribe((respuesta) => {
        this.cesta = respuesta;
        this.router.navigate(['cesta']);
      });
    });
  }

  tienePermisos(role: string): boolean {
    return this.personaServices.hasRole(role);
  }
}
