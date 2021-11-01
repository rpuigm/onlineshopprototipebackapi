import { ActivatedRoute, Router } from '@angular/router';
import { ProductoService } from './../producto/producto.service';
import { Component, OnInit } from '@angular/core';
import { Producto } from '../producto/producto.model';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-producto-item',
  templateUrl: './producto-item.component.html',
  styleUrls: ['./producto-item.component.css']
})
export class ProductoItemComponent implements OnInit {

  private imagenSeleccionada: File;

  producto: Producto;

  constructor(private productoService: ProductoService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params =>
      {
        let id:number = +params.get('id')!;
        if (id){
          this.productoService.getProductoById(id).subscribe(producto =>{
            this.producto = producto;
          });
        }
      });
  }

  selecionarFoto(event: Event){
  }

}
