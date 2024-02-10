import { Component } from '@angular/core';
import { environment } from './../environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor() {
    console.log(environment.production); 
    console.log(environment.backEndURL);
    
  }
  
  title = 'EN CONSTRUCCIÓN';
  nombre_tienda: string = 'CHRISTMASZOM'
  autor: string = 'Rubén Puig Moreno'
}
