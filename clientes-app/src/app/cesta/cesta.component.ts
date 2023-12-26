import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Pedido } from '../pedido/pedido.model';
import { PedidoService } from '../pedido/pedido.service';
import { Producto } from '../producto/producto.model';
import { ProductosPedido } from './../pedido/ProductosPedido';
import { PersonaServices } from './../persona/persona.service';
import { ProductoService } from './../producto/producto.service';
import { Cesta } from './cesta.model';
import { CestaService } from './cesta.service';
import { ProductoCantidad } from './productoCantidad.model';

@Component({
  selector: 'app-cesta',
  templateUrl: './cesta.component.html',
  styleUrls: ['./cesta.component.css'],
})
export class CestaComponent implements OnInit {
  cesta!: Cesta;
  producto!: Producto;
  productos!: Producto[];
  pedido!: Pedido;

  total!: number;

  imagenEscaparate: string;

  constructor(
    private activatedRoute: ActivatedRoute,
    private cestaService: CestaService,
    private personaService: PersonaServices,
    private productoService: ProductoService,
    private pedidoService: PedidoService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.cesta = new Cesta();

    this.setCesta();
  }

  setCesta() {
    this.cestaService
      .recuperarCesta(this.personaService.usuario.id)
      .subscribe((cesta) => {
        this.cesta = cesta;
        this.total = 0;
        console.log('numero de productos' + cesta?.productoCantidad.length);
        this.productos = [];
        for (var index in this.cesta.productoCantidad) {
          console.log('for' + this.cesta.productoCantidad[index].idProducto);
          let indice = this.cesta.productoCantidad[index].idProducto;
          let item = new Producto();
          this.productoService.getProductoById(indice).subscribe((producto) => {
            item = producto;
            this.total =
              this.total +
              producto.precio * this.cesta.productoCantidad[index].cantidad;
            producto.productoCaracteristicas.imagenesProducto[0].imagen =
              'http://https://psychic-succotash-5x944xv45qjh4wxr-8090.app.github.dev/api/productos/producto/imagen/' +
              item.productoCaracteristicas?.imagenesProducto[0]?.imagen;
            this.productos.push(item);
            console.log('itemnombre  ' + item.nombre);
          });
        }

        console.log('tamaño' + this.productos.length);
      });
  }



  recuperaProducto(idProducto: number): Producto {
    this.producto = new Producto();
    if (idProducto) {
      this.productoService.getProductoById(idProducto).subscribe((producto) => {
        this.producto = producto;
        console.log(this.producto.nombre);
      });
    }
    return this.producto;
  }

  getProductoNumero(): number {
    return this.productos.length;
  }

  getProductos(): Producto[] {
    return this.productos;
  }

  tramitarPedido() {
    this.pedido = new Pedido();
    this.pedido.estado = 'nuevo';
    this.pedido.idUsuario = this.personaService.usuario.id;
    this.pedido.total = this.total;
    let lista = new Array<ProductosPedido>();
    for (var index in this.cesta.productoCantidad) {
      let productoPedido = new ProductosPedido();
      productoPedido.nombre =
        this.productos.find(
          (x) => x.id === this.cesta.productoCantidad[index].idProducto
        )?.nombre || '';
      productoPedido.cantidad = Number(
        this.cesta.productoCantidad[index].cantidad
      );
      lista.push(productoPedido);
    }

    this.pedido.listaProcutosPedido = lista;
    console.log(this.pedido.listaProcutosPedido.length);
    this.pedidoService.setPedido(this.pedido).subscribe((respuesta) => {
      this.router.navigate(['/direccion/' + respuesta.id]);
    });
  }

  eliminaElemnetoDeCesta(id: number) {
    if (this.cesta.productoCantidad.length == 1) {
      this.cesta.productoCantidad = [];
    } else {
      let nuevalistaProductoCantidad = new Array<ProductoCantidad>();
      for (var index in this.cesta.productoCantidad) {
        if (this.cesta.productoCantidad[index].idProducto != id) {
          console.log(id + '/' + this.cesta.productoCantidad[index].id);
          let productoPedidoEnLista = new ProductoCantidad();
          productoPedidoEnLista.idProducto =
            this.cesta.productoCantidad[index].idProducto;
          productoPedidoEnLista.cantidad =
            this.cesta.productoCantidad[index].cantidad;
          nuevalistaProductoCantidad.push(productoPedidoEnLista);
        }
      }
      this.cesta.productoCantidad = nuevalistaProductoCantidad;
    }

    console.log(this.cesta.productoCantidad.length);

    this.cestaService.incluirEnCesta(this.cesta).subscribe((respuesta) => {
      this.cesta= new Cesta();
      this.cesta = respuesta;
      this.setCesta();
    });
  }
}
