import { PersonaServices } from './../persona/persona.service';
import { CestaService } from './../cesta/cesta.service';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from './producto.model';
import { Usuario } from '../login/usuario.model';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css'],
})
export class ProductoComponent implements OnInit {
  @Input() elemento: string;
  @Input() producto: Producto;

  imagenEscaparate: string;

  private usuario: Usuario;

  constructor(private router: Router, private cestaService: CestaService
    , private personaServices: PersonaServices) {

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

  agregarEnCesta(){
    console.log('cesta ' + this.personaServices.usuario.id)
    console.log(this.personaServices.usuario.id)
    this.cestaService.agregarProductoACesta(this.personaServices.usuario.id, this.producto.id);

  }


}
