import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemproductoComponent } from './itemproducto.component';

describe('ItemproductoComponent', () => {
  let component: ItemproductoComponent;
  let fixture: ComponentFixture<ItemproductoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ItemproductoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemproductoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
