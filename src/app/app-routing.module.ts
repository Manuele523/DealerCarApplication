import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'; 
import { BrandTableComponent } from './components/table/brand-table/brand-table.component';
import { ModelTableComponent } from './components/table/model-table/model-table.component';
import { OwnerTableComponent } from './components/table/owner-table/owner-table.component';
import { BrandUpdateFormComponent } from './components/updateForm/brand-update-form/brand-update-form.component';
import { ModelUpdateFormComponent } from './components/updateForm/model-update-form/model-update-form.component';
import { OwnerUpdateFormComponent } from './components/updateForm/owner-update-form/owner-update-form.component';

const routes: Routes = [
  { path: 'brand', component: BrandTableComponent, children: [
    { path: 'update', component: BrandUpdateFormComponent },
    { path: 'insert', component: BrandUpdateFormComponent }
  ]},
  { path: 'model', component: ModelTableComponent, children: [
    { path: 'update', component: ModelUpdateFormComponent },
    { path: 'insert', component: ModelUpdateFormComponent }
  ]},
  { path: 'owner', component: OwnerTableComponent, children: [
    { path: 'update', component: OwnerUpdateFormComponent },
    { path: 'insert', component: OwnerUpdateFormComponent },
  ]},
]; 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }