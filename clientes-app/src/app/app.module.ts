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
import { PersonaComponent } from './persona/persona.component';
import { AltapersonaComponent } from './altapersona/altapersona.component';
import { ProductoService } from './producto/producto.service';
import { AltaproductoComponent } from './altaproducto/altaproducto.component';
import { HttpClientModule } from '@angular/common/http';
import { ProductoItemComponent } from './producto-item/producto-item.component';
import { LoginComponent } from './login/login.component';
import { DetalleproductoComponent } from './detalleproducto/detalleproducto.component';
import { CestaComponent } from './cesta/cesta.component';
import { PedidoComponent } from './pedido/pedido.component';
import { ProductoCestaComponent } from './producto-cesta/producto-cesta.component';
import { DireccionPedidoComponent } from './direccion-pedido/direccion-pedido.component';

const routes: Routes = [
  {path:'', redirectTo:'/productosgrid', pathMatch: 'full'},
  {path:'directivas', component: DirectivaComponent},
  {path:'clientes', component: ClientesComponent},
  {path:'clientes/form', component: FormComponent},
  {path:'principal', component: PrincipalComponent},
  {path:'productosgrid', component: ProductosgridComponent},
  {path:'producto', component: ProductoComponent},
  {path:'empleados', component: EmpleadosComponent},
  {path:'altapersona', component: AltapersonaComponent},
  {path:'altaproducto', component: AltaproductoComponent},
  {path:'item/:id', component: ProductoItemComponent},
  {path:'login', component: LoginComponent},
  {path:'detalleproducto/:id', component: DetalleproductoComponent},
  {path:'cesta', component: CestaComponent}
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
    EmpleadosComponent,
    PersonaComponent,
    AltapersonaComponent,
    AltaproductoComponent,
    ProductoItemComponent,
    LoginComponent,
    DetalleproductoComponent,
    CestaComponent,
    PedidoComponent,
    ProductoCestaComponent,
    DireccionPedidoComponent

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [ClienteService,
              ProductoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
