import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderempleadoComponent } from './headerempleado.component';

describe('HeaderempleadoComponent', () => {
  let component: HeaderempleadoComponent;
  let fixture: ComponentFixture<HeaderempleadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeaderempleadoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderempleadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
