import { Router } from '@angular/router';
import { ProductoService } from './../producto/producto.service';
import { Component, OnInit } from '@angular/core';
import { Tienda } from './tienda.model';

@Component({
  selector: 'app-configuracion',
  templateUrl: './configuracion.component.html',
  styleUrls: ['./configuracion.component.css']
})
export class ConfiguracionComponent implements OnInit {

  constructor(private productoService: ProductoService,
    private router:Router) { }

  nombre: string
  tienda: Tienda;

  ngOnInit(): void {
    this.tienda= new Tienda();
  }

  setNombre(){
    console.log(this.tienda.nombreTienda)
    this.productoService.setNombreTienda(this.tienda).subscribe(
      (res)=>{this.router.navigate(['productosgrid'])}
    )
  }
  setNombreTienda(event: Event){
    this.tienda= new Tienda();
    this.tienda.id=1
    this.tienda.nombreTienda= (<HTMLInputElement>event.target).value;
  }

}
