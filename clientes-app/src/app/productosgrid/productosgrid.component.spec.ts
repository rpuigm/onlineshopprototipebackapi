import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductosgridComponent } from './productosgrid.component';

describe('ProductosgridComponent', () => {
  let component: ProductosgridComponent;
  let fixture: ComponentFixture<ProductosgridComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductosgridComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductosgridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
