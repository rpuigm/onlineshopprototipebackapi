import { Component, OnInit, Input } from '@angular/core';
import { Producto } from './producto.model';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css']
})
export class ProductoComponent implements OnInit {

  @Input() elemento: string;
  @Input() producto: Producto;

  constructor( ) {
   }

  ngOnInit(): void {
  }



}
