import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
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

  constructor(private router: Router) {

  }

  ngOnInit(): void {
    this.imagenEscaparate= "../assets/images/christmas-tree-pieces.jpg";
    this.getImagenEscaparate();
  }

  getImagenEscaparate(): void {
    if (this.producto?.productoCaracteristicas?.imagenesProducto?.length > 0)
      this.imagenEscaparate=
        'http://localhost:8090/api/productos/producto/imagen/' +
        this.producto.productoCaracteristicas.imagenesProducto[0].imagen;
  }

  irADetalleProducto(){
    this.router.navigate(['/detalleproducto/'+this.producto.id]);

  }
}
