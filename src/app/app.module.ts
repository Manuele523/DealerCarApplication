import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module'; // CLI imports
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

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
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    BrandTableComponent,
    ModelTableComponent,
    OwnerTableComponent,
    SideBarComponent,
    NavBarComponent,
    BrandUpdateFormComponent,
    ModelUpdateFormComponent,
    OwnerUpdateFormComponent,
    OwnerInsertFormComponent,
    ModelInsertFormComponent,
    BrandInsertFormComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
