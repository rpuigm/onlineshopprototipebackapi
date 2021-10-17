import { Component, OnInit } from '@angular/core';
import { Persona } from '../persona/persona.model';

@Component({
  selector: 'app-altapersona',
  templateUrl: './altapersona.component.html',
  styleUrls: ['./altapersona.component.css']
})
export class AltapersonaComponent implements OnInit {


  personas: Persona[] = [
    new Persona('Juan','Perez'),
    new Persona('Laura', 'Juarez'),
    new Persona('Karla', 'Lara')
  ];

  constructor() {
    this.personas[1]= new Persona('Juan','Perez');
   }

  ngOnInit(): void {
  }


}
