import { CestaService } from './../cesta/cesta.service';
import { PersonaServices } from './../persona/persona.service';
import { ProductoCaracteristicas } from './../producto/productoCaracteristicas.model';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductoService } from './../producto/producto.service';
import { Component, OnInit } from '@angular/core';
import { Producto } from '../producto/producto.model';
import { Cesta } from '../cesta/cesta.model';
import { ProductoCantidad } from '../cesta/productoCantidad.model';

@Component({
  selector: 'app-detalleproducto',
  templateUrl: './detalleproducto.component.html',
  styleUrls: ['./detalleproducto.component.css'],
})
export class DetalleproductoComponent implements OnInit {
  producto: Producto;
  imagenPrincipal: string;
  private cesta: Cesta;
  private listaProductoCantidad: ProductoCantidad[];

  constructor(
    private productoService: ProductoService,
    private activatedRoute: ActivatedRoute,
    private personaService: PersonaServices,
    private router: Router,
    private cestaService: CestaService
  ) {}

  ngOnInit(): void {
    this.imagenPrincipal = '../assets/images/christmas-tree-pieces.jpg';
    this.activatedRoute.paramMap.subscribe((params) => {
      let id: number = +params.get('id')!;
      if (id) {
        this.productoService.getProductoById(id).subscribe((producto) => {
          this.producto = producto;
          this.imagenPrincipal =
            'http://localhost:8090/api/productos/producto/imagen/' +
            this.producto?.productoCaracteristicas.imagenesProducto[0].imagen;
        });
      }
    });
  }

  cambiarImagen(event: Event): void {
    this.imagenPrincipal = (<HTMLImageElement>event.target).src;
  }

  getProducto(): Producto {
    return this.producto;
  }

  tienePermisos(role: string): boolean {
    return this.personaService.hasRole(role);
  }

  EliminarProducto(){
    return this.productoService.eliminarProducto(this.producto.id).subscribe(
      (x) =>{this.router.navigate(['productosgrid'])}
    );
  }

  agregarEnCesta() {
    this.cestaService.recuperarCesta(this.personaService.usuario.id).subscribe((respuesta) => {
      this.cesta = respuesta;
      if (respuesta == null) {
        this.cesta = new Cesta();
        this.cesta.idUsuario = this.personaService.usuario.id;
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
}
