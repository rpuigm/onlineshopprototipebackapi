import { Component, OnInit } from '@angular/core';
import { Persona } from '../persona/persona.model';

@Component({
  selector: 'app-altapersona',
  templateUrl: './altapersona.component.html',
  styleUrls: ['./altapersona.component.css']
})
export class AltapersonaComponent implements OnInit {


  personas: Persona[] = [

  ];

  constructor() {
   }

  ngOnInit(): void {
  }


}
