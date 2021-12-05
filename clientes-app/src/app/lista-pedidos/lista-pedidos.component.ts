import { PersonaServices } from './../persona/persona.service';
import { PedidoService } from './../pedido/pedido.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Pedido } from '../pedido/pedido.model';
import { ThisReceiver } from '@angular/compiler';

@Component({
  selector: 'app-lista-pedidos',
  templateUrl: './lista-pedidos.component.html',
  styleUrls: ['./lista-pedidos.component.css']
})
export class ListaPedidosComponent implements OnInit {

  pedidos!: Pedido[];


  constructor(private activatedRoute: ActivatedRoute,
    private pedidoService: PedidoService,
    private personaService: PersonaServices) { }

  ngOnInit(): void {
    this.pedidos= new Array<Pedido>();

    this.activatedRoute.paramMap.subscribe((params) => {
        this.pedidoService.getPedidosByIdusuario(this.personaService.usuario.id).subscribe((respuesta) => {
          this.pedidos = respuesta;
          console.log(this.pedidos.length)
        });

    });
  }



}
