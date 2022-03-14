import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// GET
import { BrandTableComponent } from './components/table/brand-table/brand-table.component';
import { ModelTableComponent } from './components/table/model-table/model-table.component';
import { OwnerTableComponent } from './components/table/owner-table/owner-table.component';
import { CarOwnerTableComponent } from './components/table/car-owner-table/car-owner-table.component';

// INSERT
import { BrandInsertFormComponent } from './components/insertForm/brand-insert-form/brand-insert-form.component';
import { ModelInsertFormComponent } from './components/insertForm/model-insert-form/model-insert-form.component';
import { OwnerInsertFormComponent } from './components/insertForm/owner-insert-form/owner-insert-form.component';
import { CarOwnerInsertFormComponent } from './components/insertForm/car-owner-insert-form/car-owner-insert-form.component';

// UPDATE
import { BrandUpdateFormComponent } from './components/updateForm/brand-update-form/brand-update-form.component';
import { ModelUpdateFormComponent } from './components/updateForm/model-update-form/model-update-form.component';
import { OwnerUpdateFormComponent } from './components/updateForm/owner-update-form/owner-update-form.component';
import { CarOwnerUpdateFormComponent } from './components/updateForm/car-owner-update-form/car-owner-update-form.component';

const routes: Routes = [
  { path: 'brand', component: BrandTableComponent },
  { path: 'brand/insert', component: BrandInsertFormComponent },
  { path: 'brand/update', component: BrandUpdateFormComponent },
  { path: 'model', component: ModelTableComponent },
  { path: 'model/insert', component: ModelInsertFormComponent },
  { path: 'model/update', component: ModelUpdateFormComponent },
  { path: 'owner', component: OwnerTableComponent },
  { path: 'owner/insert', component: OwnerInsertFormComponent },
  { path: 'owner/update', component: OwnerUpdateFormComponent },
  { path: 'car-owner', component: CarOwnerTableComponent },
  { path: 'car-owner/insert', component: CarOwnerInsertFormComponent },
  { path: 'car-owner/update', component: CarOwnerUpdateFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
