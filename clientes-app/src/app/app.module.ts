import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { DirectivaComponent } from './directiva/directiva.component';
import { ClientesComponent } from './clientes/clientes.component';
import { ClienteService } from './clientes/cliente.service';
import { RouterModule, Routes } from '@angular/router';
import { FormComponent } from './clientes/form.component';
import { FormsModule } from '@angular/forms';
import { PrincipalComponent } from './principal/principal.component';
import { ProductoComponent } from './producto/producto.component';
import { ProductosgridComponent } from './productosgrid/productosgrid.component';
import { HeaderempleadoComponent } from './headerempleado/headerempleado.component';
import { EmpleadosComponent } from './empleados/empleados.component';


const routes: Routes = [
  {path:'', redirectTo:'/productosgrid', pathMatch: 'full'},
  {path:'directivas', component: DirectivaComponent},
  {path:'clientes', component: ClientesComponent},
  {path:'clientes/form', component: FormComponent},
  {path:'principal', component: PrincipalComponent},
  {path:'productosgrid', component: ProductosgridComponent},
  {path:'producto', component: ProductoComponent},
  {path:'empleados', component: EmpleadosComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    DirectivaComponent,
    ClientesComponent,
    FormComponent,
    PrincipalComponent,
    ProductoComponent,
    ProductosgridComponent,
    HeaderempleadoComponent,
    EmpleadosComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [ClienteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
