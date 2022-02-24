import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModelUpdateFormComponent } from './model-update-form.component';

describe('ModelUpdateFormComponent', () => {
  let component: ModelUpdateFormComponent;
  let fixture: ComponentFixture<ModelUpdateFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModelUpdateFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModelUpdateFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
