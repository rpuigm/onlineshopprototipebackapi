import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AltapersonaComponent } from './altapersona.component';

describe('AltapersonaComponent', () => {
  let component: AltapersonaComponent;
  let fixture: ComponentFixture<AltapersonaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AltapersonaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AltapersonaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
