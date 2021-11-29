import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductoCestaComponent } from './producto-cesta.component';

describe('ProductoCestaComponent', () => {
  let component: ProductoCestaComponent;
  let fixture: ComponentFixture<ProductoCestaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductoCestaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductoCestaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
