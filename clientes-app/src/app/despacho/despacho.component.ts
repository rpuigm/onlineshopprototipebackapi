import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { filter } from 'rxjs/operators';
import { Pedido } from '../pedido/pedido.model';
import { PedidoService } from '../pedido/pedido.service';
import { PersonaServices } from '../persona/persona.service';

@Component({
  selector: 'app-despacho',
  templateUrl: './despacho.component.html',
  styleUrls: ['./despacho.component.css'],
})
export class DespachoComponent implements OnInit {
  pedidos!: Pedido[];

  constructor(
    private activatedRoute: ActivatedRoute,
    private pedidoService: PedidoService,
    private personaService: PersonaServices
  ) {}

  ngOnInit(): void {
    this.pedidos = new Array<Pedido>();

      this.pedidoService
        .getPedidos()
        .subscribe((respuesta) => {
          this.pedidos = respuesta;
          console.log(this.pedidos.length);
        });
  }

  setEstadoPedidoPagado(id:number) {
    let pedido= new Pedido();
    pedido = this.pedidos.find(x=>x.id==id)|| new Pedido();
    pedido.estado='Despachado';
    this.pedidoService.setPedido(pedido).subscribe(
      () => {}
    );

  }
}
