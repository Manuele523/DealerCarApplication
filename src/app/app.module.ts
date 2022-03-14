import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { NgbModalModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module'; // CLI imports
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

import { AppComponent } from './app.component';
import { BrandTableComponent } from './components/table/brand-table/brand-table.component';
import { ModelTableComponent } from './components/table/model-table/model-table.component';
import { OwnerTableComponent } from './components/table/owner-table/owner-table.component';
import { SideBarComponent } from './components/side-bar/side-bar.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { BrandUpdateFormComponent } from './components/updateForm/brand-update-form/brand-update-form.component';
import { ModelUpdateFormComponent } from './components/updateForm/model-update-form/model-update-form.component';
import { OwnerUpdateFormComponent } from './components/updateForm/owner-update-form/owner-update-form.component';
import { OwnerInsertFormComponent } from './components/insertForm/owner-insert-form/owner-insert-form.component';
import { ModelInsertFormComponent } from './components/insertForm/model-insert-form/model-insert-form.component';
import { BrandInsertFormComponent } from './components/insertForm/brand-insert-form/brand-insert-form.component';
import { CarOwnerTableComponent } from './components/table/car-owner-table/car-owner-table.component';
import { CarOwnerInsertFormComponent } from './components/insertForm/car-owner-insert-form/car-owner-insert-form.component';
import { CarOwnerUpdateFormComponent } from './components/updateForm/car-owner-update-form/car-owner-update-form.component';

@NgModule({
  declarations: [
    AppComponent,
    SideBarComponent,
    NavBarComponent,
    BrandTableComponent,
    BrandInsertFormComponent,
    BrandUpdateFormComponent,

    ModelTableComponent,
    ModelInsertFormComponent,
    ModelUpdateFormComponent,

    OwnerTableComponent,
    OwnerInsertFormComponent,
    OwnerUpdateFormComponent,

    CarOwnerTableComponent,
     CarOwnerInsertFormComponent,
     CarOwnerUpdateFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    NgbModalModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
