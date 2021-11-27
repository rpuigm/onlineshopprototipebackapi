import { Usuario } from './../login/usuario.model';
import { PersonaServices } from './../persona/persona.service';
import { CestaService } from './cesta.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Cesta } from './cesta.model';

@Component({
  selector: 'app-cesta',
  templateUrl: './cesta.component.html',
  styleUrls: ['./cesta.component.css']
})
export class CestaComponent implements OnInit {

  cesta!: Cesta;

  constructor(private activatedRoute: ActivatedRoute,
    private cestaService: CestaService,
    private personaService: PersonaServices) { }

  ngOnInit(): void {
    this.cesta= new Cesta();

    this.cestaService.recuperarCesta(this.personaService.usuario.id).subscribe((cesta) => {
      this.cesta = cesta;
    });



  }



}
