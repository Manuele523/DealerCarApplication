import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerUpdateFormComponent } from './owner-update-form.component';

describe('OwnerUpdateFormComponent', () => {
  let component: OwnerUpdateFormComponent;
  let fixture: ComponentFixture<OwnerUpdateFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OwnerUpdateFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerUpdateFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
