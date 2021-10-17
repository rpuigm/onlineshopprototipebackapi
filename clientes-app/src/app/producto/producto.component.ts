import { Component, OnInit, Input } from '@angular/core';
import { Persona } from '../persona/persona.model';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css']
})
export class ProductoComponent implements OnInit {

  @Input() elemento!: string;

  constructor( ) {
   }

  ngOnInit(): void {
  }



}
