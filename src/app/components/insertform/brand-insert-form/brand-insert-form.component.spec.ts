import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BrandInsertFormComponent } from './brand-insert-form.component';

describe('BrandInsertFormComponent', () => {
  let component: BrandInsertFormComponent;
  let fixture: ComponentFixture<BrandInsertFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BrandInsertFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BrandInsertFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
