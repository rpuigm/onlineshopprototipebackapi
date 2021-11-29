import { CestaService } from './../cesta/cesta.service';
import { PedidoService } from './../pedido/pedido.service';
import { DireccionPedido } from './direccion-pedido.model';
import { Component, OnInit } from '@angular/core';
import { ProductoService } from '../producto/producto.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Pedido } from '../pedido/pedido.model';

@Component({
  selector: 'app-direccion-pedido',
  templateUrl: './direccion-pedido.component.html',
  styleUrls: ['./direccion-pedido.component.css']
})
export class DireccionPedidoComponent implements OnInit {

  direccionPedido!: DireccionPedido;
  pedido!: Pedido;

  constructor(
    private productoService: ProductoService,
    private pedidoService: PedidoService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.direccionPedido = new DireccionPedido();
    this.activatedRoute.paramMap.subscribe((params) => {
      let id: number = +params.get('id')!;
      if (id) {
        this.pedidoService.getPedidoById(id).subscribe((respuesta) => {
          this.pedido = respuesta;
        });
      }
    });
  }


  setVia(event: Event){
    this.direccionPedido.via= (<HTMLInputElement>event.target).value;
  }
  setCp(event: Event){
    this.direccionPedido.cp= Number((<HTMLInputElement>event.target).value);
  }
  setLocalidad(event: Event){
    this.direccionPedido.localidad= (<HTMLInputElement>event.target).value;
  }
  setProvincia(event: Event){
    this.direccionPedido.pronvicia= (<HTMLInputElement>event.target).value;
  }
  setNumero(event: Event){
    this.direccionPedido.numero= Number((<HTMLInputElement>event.target).value);
  }

  guardadPedidoConDireccion(){
    this.pedido.direccionPedido = this.direccionPedido
    this.pedidoService.setPedido(this.pedido).subscribe((respuesta) => {
      this.router.navigate(['/pasarela/' + respuesta.id]);
    });

  }
}
