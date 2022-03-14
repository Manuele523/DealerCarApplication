import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarOwnerUpdateFormComponent } from './car-owner-update-form.component';

describe('CarOwnerUpdateFormComponent', () => {
  let component: CarOwnerUpdateFormComponent;
  let fixture: ComponentFixture<CarOwnerUpdateFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarOwnerUpdateFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CarOwnerUpdateFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
