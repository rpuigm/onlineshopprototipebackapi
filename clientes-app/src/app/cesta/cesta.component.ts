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

  cesta: Cesta;

  constructor(private activatedRoute: ActivatedRoute,
    private cestaService: CestaService) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((params) => {
      let id: number = +params.get('id')!;
      if (id) {
        this.cestaService.recuperarCesta(id).subscribe((cesta) => {
          this.cesta = cesta;
        });
      }
    });
  }



}
