import { PersonaServices } from './../persona/persona.service';
import { ProductoCaracteristicas } from './../producto/productoCaracteristicas.model';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductoService } from './../producto/producto.service';
import { Component, OnInit } from '@angular/core';
import { Producto } from '../producto/producto.model';

@Component({
  selector: 'app-detalleproducto',
  templateUrl: './detalleproducto.component.html',
  styleUrls: ['./detalleproducto.component.css'],
})
export class DetalleproductoComponent implements OnInit {
  producto: Producto;
  imagenPrincipal: string;

  constructor(
    private productoService: ProductoService,
    private activatedRoute: ActivatedRoute,
    private personaService: PersonaServices
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
}
