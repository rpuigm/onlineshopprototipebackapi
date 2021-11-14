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
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params =>
      {
        let id:number = +params.get('id')!;
        if (id){
          this.productoService.getProductoById(id).subscribe(producto =>{
            this.producto = producto;
          });
        }
      });
    this.imagenPrincipal=this.producto.productoCaracteristicas.imagenesProducto[1].imagen;
  }

  cambiarImagen(event: Event): void{
    this.imagenPrincipal=(<HTMLImageElement>event.target).src;
  }
}
