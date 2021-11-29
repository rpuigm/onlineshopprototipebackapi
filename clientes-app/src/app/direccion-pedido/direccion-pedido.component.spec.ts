import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DireccionPedidoComponent } from './direccion-pedido.component';

describe('DireccionPedidoComponent', () => {
  let component: DireccionPedidoComponent;
  let fixture: ComponentFixture<DireccionPedidoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DireccionPedidoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DireccionPedidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
