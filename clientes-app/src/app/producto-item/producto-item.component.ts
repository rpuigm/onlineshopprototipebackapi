import { map } from 'rxjs/operators';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductoService } from './../producto/producto.service';
import { Component, OnInit, OnChanges, SimpleChanges } from '@angular/core';
import { Producto } from '../producto/producto.model';
import { ThrowStmt } from '@angular/compiler';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-producto-item',
  templateUrl: './producto-item.component.html',
  styleUrls: ['./producto-item.component.css']
})
export class ProductoItemComponent implements OnInit, OnChanges {

  private imagenSeleccionada: File;
  private descripcionImagen: string;

  producto: Producto;

  constructor(private productoService: ProductoService,
    private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.productoService.getProductoById(this.producto.id).subscribe(producto =>{
            this.producto = producto;
            console.log(this.producto?.productoCaracteristicas.descripcion);
          });
  }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params =>
      {
        let id:number = +params.get('id')!;
        if (id){
          this.productoService.getProductoById(id).subscribe(producto =>{
            this.producto = producto;
            console.log(this.producto?.productoCaracteristicas.descripcion);
          });
        }
      });
  }

  selecionarFoto(event: Event){
    this.imagenSeleccionada = (<HTMLInputElement>event.target).files![0];
  }

  asignarDescripcion(event: Event){
    this.descripcionImagen = (<HTMLInputElement>event.target).value;
  }


  subirImagen(){
    this.productoService.subirFoto(this.imagenSeleccionada, String(this.producto.id), this.descripcionImagen)
    .subscribe(producto => {
      this.producto = producto;
    });
  }

  botonTerminar(): void {
    this.router.navigate(["/detalleproducto/"+ this.producto.id]);
  }


  eliminaImagen(imagen: string){
    this.productoService.eliminarImagen(imagen).subscribe(producto => {
      this.producto = producto;
    });
  }



}
