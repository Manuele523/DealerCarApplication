import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarOwnerInsertFormComponent } from './car-owner-insert-form.component';

describe('CarOwnerInsertFormComponent', () => {
  let component: CarOwnerInsertFormComponent;
  let fixture: ComponentFixture<CarOwnerInsertFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarOwnerInsertFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CarOwnerInsertFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
