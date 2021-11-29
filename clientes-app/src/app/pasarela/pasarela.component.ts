import { PedidoService } from './../pedido/pedido.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { DireccionPedido } from '../direccion-pedido/direccion-pedido.model';
import { Pedido } from '../pedido/pedido.model';
import swal from 'sweetalert2'

@Component({
  selector: 'app-pasarela',
  templateUrl: './pasarela.component.html',
  styleUrls: ['./pasarela.component.css']
})
export class PasarelaComponent implements OnInit {

  direccionPedido!: DireccionPedido;
  pedido!: Pedido;

  strikeCheckout:any = null;

  constructor(private activatedRoute: ActivatedRoute,
    private pedidoService: PedidoService) { }

  ngOnInit() {
    this.stripePaymentGateway();
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



  checkout(amount: number) {
    const strikeCheckout = (<any>window).StripeCheckout.configure({
      key: 'pk_test_51K19jpBS2gG7ym34MIHV7eVZ26NCetefYjlAYEZu2Gx1IA555fEVfoivTlftfypfaGidYLTPq3ScFsVMcfXJ6Yfo5gv00sfk75sN3',
      locale: 'auto',
      token: function (stripeToken: any) {
        console.log(stripeToken)
        this.setEstadoPedidoPagado()
        swal.fire("Pedido confirmado", "El pedido está confirmado y será enviado a su dirección", "success")
      }
    });

    strikeCheckout.open({
      name: 'RemoteStack',
      description: 'Payment widgets',
      amount: amount * 100
    });
  }

  stripePaymentGateway() {
    if(!window.document.getElementById('stripe-script')) {
      const scr = window.document.createElement("script");
      scr.id = "stripe-script";
      scr.type = "text/javascript";
      scr.src = "https://checkout.stripe.com/checkout.js";

      scr.onload = () => {
        this.strikeCheckout = (<any>window).StripeCheckout.configure({
          key: 'pk_test_51K19jpBS2gG7ym34MIHV7eVZ26NCetefYjlAYEZu2Gx1IA555fEVfoivTlftfypfaGidYLTPq3ScFsVMcfXJ6Yfo5gv00sfk75sN3',
          locale: 'auto',
          token: function (token: any) {
            console.log(token)
            alert('Payment via stripe successfull!');
          }
        });
      }

      window.document.body.appendChild(scr);
    }
  }

  setEstadoPedidoPagado(){
    this.pedido.estado='Pagado'
  }


}
