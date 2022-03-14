import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarOwnerTableComponent } from './car-owner-table.component';

describe('CarOwnerTableComponent', () => {
  let component: CarOwnerTableComponent;
  let fixture: ComponentFixture<CarOwnerTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarOwnerTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CarOwnerTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
