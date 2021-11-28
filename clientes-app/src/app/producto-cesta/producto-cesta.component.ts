import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cesta } from '../cesta/cesta.model';
import { CestaService } from '../cesta/cesta.service';
import { ProductoCantidad } from '../cesta/productoCantidad.model';
import { PersonaServices } from '../persona/persona.service';
import { Producto } from '../producto/producto.model';

@Component({
  selector: 'app-producto-cesta',
  templateUrl: './producto-cesta.component.html',
  styleUrls: ['./producto-cesta.component.css']
})
export class ProductoCestaComponent implements OnInit {

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
        'http://localhost:8090/api/productos/producto/imagen/' +
        this.producto.productoCaracteristicas.imagenesProducto[0].imagen;
  }

}
