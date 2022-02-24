import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModelInsertFormComponent } from './model-insert-form.component';

describe('ModelInsertFormComponent', () => {
  let component: ModelInsertFormComponent;
  let fixture: ComponentFixture<ModelInsertFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModelInsertFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModelInsertFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
