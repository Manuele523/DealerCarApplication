import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerInsertFormComponent } from './owner-insert-form.component';

describe('OwnerInsertFormComponent', () => {
  let component: OwnerInsertFormComponent;
  let fixture: ComponentFixture<OwnerInsertFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OwnerInsertFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerInsertFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
